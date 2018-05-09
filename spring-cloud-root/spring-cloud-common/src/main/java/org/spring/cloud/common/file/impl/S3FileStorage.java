package org.spring.cloud.common.file.impl;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

import org.apache.commons.lang.StringUtils;
import org.spring.cloud.common.file.FileStorage;
import org.springframework.http.MediaType;

import com.amazonaws.services.s3.AmazonS3Client;
import com.amazonaws.services.s3.model.ObjectMetadata;
import com.amazonaws.services.s3.model.S3Object;

public class S3FileStorage implements FileStorage {
	
	private AmazonS3Client client;
	private String bucketName;
	
	public S3FileStorage(String bucketName) {
		this.bucketName = bucketName;
	}
	public S3FileStorage withS3Client(AmazonS3Client client) {
		this.client = client;
		return this;
	}
	public S3FileStorage init() {
		if (!client.doesBucketExist(bucketName)) {
			client.createBucket(bucketName);
		}
		return this;
	}

	@Override
	public void saveOrUpdate(
			String path,
			InputStream inputstream,
			String contentType,
			Map<String, String> metadata) throws Exception {

		if (StringUtils.isBlank(contentType)) {
			contentType = MediaType.APPLICATION_OCTET_STREAM_VALUE;
		}

		ObjectMetadata objectMetadata = new ObjectMetadata();

		objectMetadata.setContentType(contentType);
		objectMetadata.setContentLength(inputstream.available());
		if (null != metadata) {
			objectMetadata.setUserMetadata(metadata);
		}
		client.putObject(bucketName, path, inputstream, objectMetadata);
	}
	
	@Override
	public byte[] get(String key) throws IOException {
		S3Object fileObject = client.getObject(bucketName, key);
		InputStream inputStream = fileObject.getObjectContent();
		ByteArrayOutputStream baoStream = new ByteArrayOutputStream();
		try {
			byte[] buf = new byte[1024];
			int count = inputStream.read(buf);
			while (count != -1) {
				baoStream.write(buf, 0, count);
				count = inputStream.read(buf);
			}
		} finally {
			if (null != inputStream) {
				inputStream.close();
			}
			if (null != baoStream) {
				baoStream.close();
			}
		}
		return baoStream.toByteArray();
	}

	@Override
	public Boolean remove(String key) throws Exception {
		client.deleteObject(bucketName, key);
		return true;
	}

	@Override
	public InputStream getAsStream(String filePath) throws IOException {
		S3Object fileObject = client.getObject(bucketName, filePath);
		return fileObject.getObjectContent();
	}
	@Override
	public boolean copyFile2NewFile(String oriPath, String aimPath) {
		return false;
	}

}
