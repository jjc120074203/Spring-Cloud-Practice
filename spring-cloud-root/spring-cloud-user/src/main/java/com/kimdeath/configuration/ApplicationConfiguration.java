package com.kimdeath.configuration;

import org.spring.cloud.common.api.ServiceErrorDecoder;
import org.spring.cloud.common.file.FileStorage;
import org.spring.cloud.common.file.impl.LocalFileStorage;
import org.spring.cloud.common.web.auth.AuthUserContext;
import org.spring.cloud.common.web.interceptor.AuthInterceptorHelper;
import org.spring.cloud.common.web.interceptor.ErrorPathHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.data.redis.connection.jedis.JedisConnectionFactory;
import org.springframework.data.redis.core.RedisTemplate;
import org.springframework.http.client.ClientHttpRequestFactory;
import org.springframework.http.client.HttpComponentsClientHttpRequestFactory;
import org.springframework.web.client.RestTemplate;

import com.fasterxml.jackson.databind.DeserializationFeature;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.kimdeath.configuration.auth.IamOAuthHelper;
import com.kimdeath.configuration.auth.ResponseErrorHandler;

import feign.codec.ErrorDecoder;

/**
 * Created by jzbmufeng on 2017/2/24.
 */
@Configuration
public class ApplicationConfiguration {


    @Bean
    public AuthInterceptorHelper authInterceptorHelper() {
        return new AuthInterceptorHelper();
    }

    @Bean
    public AuthUserContext authUserContext(IamOAuthHelper iamOAuthHelper) {
        return new AuthUserContext(iamOAuthHelper);
    }

    @Bean
    public ErrorDecoder errorDecoder() {
        return new ServiceErrorDecoder();
    }
    
    @Bean
    public RestTemplate iamRestTemplate() {
        ClientHttpRequestFactory clientHttpRequestFactory = new HttpComponentsClientHttpRequestFactory(); 
        RestTemplate restTemplate = new RestTemplate(clientHttpRequestFactory);
        restTemplate.setErrorHandler(new ResponseErrorHandler());
        return restTemplate;  
    }


    @Bean
    public ObjectMapper objectMapper() {
        ObjectMapper objectMapper = new ObjectMapper();
        objectMapper.disable(DeserializationFeature.FAIL_ON_UNKNOWN_PROPERTIES);
        return objectMapper;
    }

    @SuppressWarnings("rawtypes")
	@Bean
    public RedisTemplate redisTemplate(JedisConnectionFactory connectionFactory) {
        RedisTemplate rt = new RedisTemplate();
        rt.setConnectionFactory(connectionFactory);
        return rt;
    }

    @Bean
    public ErrorPathHandler errorPathHandler() {
        return new ErrorPathHandler();
    }

    @Bean
    public FileStorage fileStorage() {
        return new LocalFileStorage();
    }
//
//    @Bean
//    public ISVCFile isvcFile() {
//        return new ISVCFileImpl();
//    }

}
