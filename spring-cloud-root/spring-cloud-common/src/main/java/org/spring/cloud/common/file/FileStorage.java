package org.spring.cloud.common.file;

import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * Created by jiazaibo on 17-3-31.
 */
public interface FileStorage {

    void saveOrUpdate(String path, InputStream inputstream, String contentType, Map<String, String> metadata) throws Exception;

    byte[] get(String filePath) throws IOException;

    Boolean remove(String filePath) throws Exception;

    InputStream getAsStream(String filePath) throws IOException;

    boolean copyFile2NewFile(String oriPath,String aimPath);
}
