package org.spring.cloud.common.web.exception;

import java.io.IOException;
import java.io.PrintWriter;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.commons.lang.StringUtils;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.cloud.common.exception.CIBaseException;
import org.spring.cloud.common.web.result.ResponseErrorResult;
import org.springframework.web.servlet.HandlerExceptionResolver;
import org.springframework.web.servlet.ModelAndView;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.netflix.hystrix.exception.HystrixRuntimeException;

/**
 * Created by jiazaibo on 17-2-27.
 */
public class ServiceHandlerExceptionResolver implements HandlerExceptionResolver {

    Logger logger = LoggerFactory.getLogger(ServiceHandlerExceptionResolver.class);

    public ObjectMapper mapper = new ObjectMapper();

    private String errCodePattern = "^(0x[0-9A-F]{6})=(.+)";

    public ModelAndView resolveException(HttpServletRequest httpServletRequest, HttpServletResponse httpServletResponse, Object o, Exception e) {

        e.printStackTrace();

        Throwable rex = e;

        if (e instanceof HystrixRuntimeException) {
            rex = e.getCause();
        }

        if (rex instanceof CIBaseException) {

            CIBaseException cbe = (CIBaseException) rex;
            if (StringUtils.isBlank(cbe.getErrCode())
                    && cbe.getMessage().matches(this.errCodePattern)) {
                String [] cm = this.parseCodeMessage(cbe.getMessage());
                this.writeError(cm[0], cm[1], httpServletResponse);
            } else {
                this.writeError(cbe.getErrCode(), rex.getMessage(), httpServletResponse);
            }

        } else  {
            this.writeError("", "系统运行出错", httpServletResponse);
        }

        return new ModelAndView();
    }

    private void writeError(String code, String message, HttpServletResponse response) {
        ResponseErrorResult result = new ResponseErrorResult();
        result.setHasError(true);
        result.setCode(code);
        result.setMessage(message);

        try {
            String body = this.mapper.writeValueAsString(result);
            this.writeToResponse(response, HttpServletResponse.SC_OK, "application/json", "UTF-8", body);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
    }


    private void writeToResponse(
            HttpServletResponse response,
            int status,
            String contentType,
            String charset,
            String body) {
        response.setStatus(status);
        response.setCharacterEncoding(charset);
        response.setContentType(contentType);

        PrintWriter writer = null;
        try {
            writer = response.getWriter();
            writer.write(body);
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            if (null != writer) {
                writer.close();
            }
        }
    }

    private String [] parseCodeMessage(String message) {
        String [] cm = new String[2];

        Matcher matcher = Pattern.compile(this.errCodePattern).matcher(message);
        if (matcher.find()) {
            cm[0] = matcher.group(1);
            cm[1] = matcher.group(2);
        } else {
            cm[0] = "";
            cm[1] = message;
        }
        return cm;
    }

}
