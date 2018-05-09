package org.spring.cloud.common.api;

import java.io.IOException;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.spring.cloud.common.exception.CIBaseException;

import com.fasterxml.jackson.databind.ObjectMapper;

import feign.Response;
import feign.Util;
import feign.codec.ErrorDecoder;

/**
 * Created by jiazaibo on 17-2-27.
 */
public class ServiceErrorDecoder implements ErrorDecoder {

    Logger logger = LoggerFactory.getLogger(ServiceErrorDecoder.class);

    private ObjectMapper objectMapper = new ObjectMapper();

    private String errCodePattern = "^(0x[0-9A-F]{6})=(.+)";

    public Exception decode(String s, Response response) {
        CIBaseException ex = null;
        try {
            if(response.body() != null) {
                String body = Util.toString(response.body().asReader());
                logger.error(body);
                ExceptionInfo ei = this.objectMapper.readValue(body.getBytes("UTF-8"), ExceptionInfo.class);

                String message = ei.getMessage();
                String code = "";

                if (message.matches(this.errCodePattern)) {
                    String [] cm = this.parseCodeMessage(message);
                    code = cm[0];
                    message = cm[1];
                    ex = new CIBaseException(CIBaseException.BIZ_EXCEPTION, code, message);
                }
            }
        } catch (IOException var4) {
            var4.printStackTrace();
            ex = new CIBaseException(CIBaseException.UNKNOWN_EXCEPTION, "", "系统运行异常");
        }

        return null != ex ? ex : new CIBaseException(CIBaseException.UNKNOWN_EXCEPTION, "", "系统运行异常");
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
