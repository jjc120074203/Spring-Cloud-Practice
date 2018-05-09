package com.kimdeath.configuration;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import com.kimdeath.configuration.annotation.ExcludeFeginFalg;

import feign.Contract;
 
/**
 * @author 启动fegin 原生注解 使用 spring-mvc 注解
 *
 */
@Configuration
@ExcludeFeginFalg//过滤扫描标识
public class FeginConfiguration {
	//默认设置Fegin原生注解
	@Bean
	public Contract feginContract(){
		return new feign.Contract.Default();
	}

//    //取消Hystrix熔断器效果  Fegin原生注解
//	@Bean
//	@Scope("prototype")
//	public Feign.Builder feignBuilder() {
//		return Feign.builder();
//	}
}
