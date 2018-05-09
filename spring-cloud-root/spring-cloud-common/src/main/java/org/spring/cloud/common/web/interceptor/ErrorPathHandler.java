package org.spring.cloud.common.web.interceptor;

import org.apache.commons.lang.StringUtils;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;

import javax.servlet.http.HttpServletResponse;

/**
 * Created by jiazaibo on 17-4-21.
 */
public class ErrorPathHandler {

    @Value("${server.error.path:${error.path:/error}}")
    private String errorPath;


    public boolean isErrorPath(String path) {
        return StringUtils.equals(path, this.errorPath);
    }

    public String getError(int status) {
        return HttpStatus.valueOf(status).getReasonPhrase();
    }







}
