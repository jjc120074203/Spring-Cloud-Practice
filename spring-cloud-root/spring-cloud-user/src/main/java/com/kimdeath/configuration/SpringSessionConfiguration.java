/*package com.kimdeath.configuration;

import org.apache.commons.lang.StringUtils;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.env.Environment;
import org.springframework.session.data.redis.config.annotation.web.http.EnableRedisHttpSession;
import org.springframework.session.web.http.HeaderHttpSessionStrategy;
import org.springframework.session.web.http.HttpSessionStrategy;

*//**
 * Created by chenjl on 17-3-21.
 *//*
@Configuration
@EnableRedisHttpSession
public class SpringSessionConfiguration {

    @Bean
    public HttpSessionStrategy httpSessionStrategy(Environment env) {
        HeaderHttpSessionStrategy hhss =  new HeaderHttpSessionStrategy();

//        String sessionHeaderName = env.getProperty("server.session.header.name");
        
        String sessionHeaderName = "spring-cloud";

        if (StringUtils.isNotBlank(sessionHeaderName)) {
            hhss.setHeaderName(sessionHeaderName);
        }

        return hhss;
    }


}
*/