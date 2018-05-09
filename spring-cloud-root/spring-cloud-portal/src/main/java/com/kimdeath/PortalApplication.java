package com.kimdeath;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.client.circuitbreaker.EnableCircuitBreaker;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.cloud.netflix.feign.EnableFeignClients;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.kimdeath.configuration.annotation.ExcludeFeginFalg;

@SpringBootApplication
@EnableEurekaClient //Eureka Client
@EnableFeignClients//Fegin clients
@EnableCircuitBreaker //Hystrix 熔断器注解
//过滤ExcludeFeginFalg 注解扫描代码
@ComponentScan(excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,value=ExcludeFeginFalg.class)})
public class PortalApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(PortalApplication.class).web(true).run(args);
	}
}
