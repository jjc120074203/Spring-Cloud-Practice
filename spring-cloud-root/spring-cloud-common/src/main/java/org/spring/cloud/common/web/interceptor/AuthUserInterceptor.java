package org.spring.cloud.common.web.interceptor;

import java.io.IOException;
import java.io.PrintWriter;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.cloud.common.web.auth.AuthUser;
import org.spring.cloud.common.web.auth.AuthUserContext;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.servlet.handler.HandlerInterceptorAdapter;

import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * Created by jzbmufeng on 2017/3/14.
 */
public class AuthUserInterceptor extends HandlerInterceptorAdapter {
	
	Logger logger = LoggerFactory.getLogger(AuthUserInterceptor.class);

    @Autowired
    private AuthInterceptorHelper authInterceptorHelper;

    @Autowired
    private ObjectMapper objectMapper;

    @Autowired
    private Environment env;

    @Autowired(required = false)
    private ErrorPathHandler errorPathHandler;


    public AuthUserInterceptor(){}

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {

        AuthUserContext auc = AuthUserContext.getContext().withRequest(request);

        String path = request.getServletPath();

        if (null != this.errorPathHandler && this.errorPathHandler.isErrorPath(path)) {
            int code = response.getStatus();
            String message = this.errorPathHandler.getError(code);
            this.sendAuthenticationError(response, new AuthError(""+code, message));
            return false;
        }


        if (this.authInterceptorHelper.ignoredAuthenticationPath(path)) return true;

//        String authHeader = env.getProperty("server.session.header.name");
        String authHeader = "spring-cloud";

        String authToken = request.getHeader(authHeader);

        if (StringUtils.isBlank(authToken)) {
        	logger.error("Cable-Services-Auth-Token header not exist!");
            this.sendAuthenticationError(response, new AuthError("0x100000", "用户未登录，请登录"));
            return false;
        }


        AuthUser au = auc.getAuthUser();

        if (null == au) {
        	logger.error("AuthUser is null");
            this.sendAuthenticationError(response, new AuthError("0x100000", "用户未登录，请登录"));
            return false ;
        }

        return true;
    }

    private void sendAuthenticationError(HttpServletResponse response, AuthError error) {
        response.setStatus(HttpServletResponse.SC_OK);
        response.setCharacterEncoding("utf-8");
        response.setContentType("application/json");
        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(this.objectMapper.writeValueAsString(error));
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            writer.close();
        }
    }



    private static class AuthError {
        private boolean hasError = true;
        private String code;
        private String message;
        public AuthError(String code, String message) {
            this.code = code;
            this.message = message;
        }

        public String getCode() {
            return code;
        }

        public String getMessage() {
            return message;
        }

        public boolean isHasError() {
            return hasError;
        }
    }

}
