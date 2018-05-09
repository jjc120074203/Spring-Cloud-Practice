package com.kimdeath.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kimdeath.configuration.annotation.ExcludeFeginFalg;

import feign.auth.BasicAuthRequestInterceptor;


/**
 * 
 * 配置注册中心权限密码
 * 3.@FeignClient(name="xxxx",url="注册中心地址")
 *  	3.1 访问的时候 @RequestMapping(value="/eureka/apps/实例名称",method=RequestMethod.GET)
 *  		注册中心地址+/eureka/apps/实例名称 :访问的是注册中心 实例的信息 name 只是别名
 *  
 * @author issuser
 *
 */
@Configuration
@ExcludeFeginFalg//过滤扫描标识
public class FeginAuthConfiguation {
	 @Bean
	    public BasicAuthRequestInterceptor basicAuthRequestInterceptor() {
	        return new BasicAuthRequestInterceptor("admin", "1q2w3e4r!");
	    }
}
