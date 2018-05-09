package org.spring.cloud.common.file.impl;

import java.io.BufferedInputStream;
import java.io.ByteArrayOutputStream;
import java.io.Closeable;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Arrays;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.cloud.common.file.FileStorage;

public class LocalFileStorage implements FileStorage {

    Logger logger = LoggerFactory.getLogger(LocalFileStorage.class);

    private static final int MAX_BUFFER_SIZE = 1024;

    /**
     * 存放文件的基准路径
     */
    private String basePath;

    public LocalFileStorage() {
        this("");
    }

    public LocalFileStorage(String basePath) {
        // 如果没有指定基准路径，则使用用户根目录
        if (StringUtils.isBlank(basePath)) {
            this.basePath = StringUtils.join(Arrays.asList(getUserHome(), ".storage"), File.separator);
        }
        File baseDir = new File(this.basePath);
        if (baseDir.exists() && baseDir.isDirectory()) {
            return;
        } else {
            if (baseDir.canWrite()) {
                baseDir.mkdirs();
            } else {
                logger.error("no write permission to path({}).", this.basePath);
            }
        }
    }

    private String getUserHome() {
        return System.getProperty("user.home");
    }

    @Override
    public void saveOrUpdate(
            String filePath,
            InputStream inputStream,
            String contentType,
            Map<String, String> metadata) throws IOException {
        File file = new File(this.getFilePath(filePath));

        if (file.exists()) file.delete();
        File parentFile = file.getParentFile();
        if (!parentFile.exists()) parentFile.mkdirs();

        FileOutputStream fos = null;
        BufferedInputStream bis = null;
        try {
            fos = new FileOutputStream(file);
            bis = new BufferedInputStream(inputStream);
            byte [] buf = new byte[MAX_BUFFER_SIZE];
            int length = bis.read(buf);
            while (length != -1) {
                fos.write(buf, 0, length);
                length = bis.read(buf);
            }
            fos.flush();
        } finally {
            close(bis);
            close(fos);
        }

    }

    @Override
    public byte[] get(String filePath) throws IOException {
        InputStream inputStream = this.getAsStream(filePath);
        ByteArrayOutputStream baos = new ByteArrayOutputStream();

        try {
            byte[] buf = new byte[MAX_BUFFER_SIZE];
            int count = inputStream.read(buf);
            while (count != -1) {
                baos.write(buf, 0, count);
                count = inputStream.read(buf);
            }
        } finally {
            this.close(inputStream);
            this.close(baos);
        }

        return baos.toByteArray();
    }

    private String getFilePath (String filePath) {
        return StringUtils.join(
                Arrays.asList(this.basePath, filePath),
                File.separator);
    }

    private void close(Closeable c) {
        if (null != c) {
            try {
                c.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    @Override
    public InputStream getAsStream(String filePath) throws IOException {
        return new FileInputStream(this.getFilePath(filePath));
    }

    @Override
    public Boolean remove(String filePath) throws Exception {
        String p = this.getFilePath(filePath);
        File f = new File(p);
        if (f.exists()) {
            return f.delete();
        }
        return true;
    }
    @Override
    public boolean copyFile2NewFile(String oriPath,String aimPath) {
		try {
			  int  byteread  =  0;    
			File f=new File(getFilePath(oriPath));
			
			File aimf=new File(getFilePath(aimPath));
			 File parentFile = aimf.getParentFile();
		      if (!parentFile.exists()) parentFile.mkdirs();
			if (f.exists()) {
				InputStream fis=new FileInputStream(f);
				FileOutputStream fos= new FileOutputStream(getFilePath(aimPath));
				byte[]  buffer  =  new  byte[MAX_BUFFER_SIZE];  
				while ((byteread  =  fis.read(buffer))  !=  -1) {
					fos.write(buffer, 0, byteread);
				}
				fis.close();
			}
		} catch (FileNotFoundException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		} catch (IOException e) {
			e.printStackTrace();
			return Boolean.FALSE;
		}
		return Boolean.TRUE;
	}


}