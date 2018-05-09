package com.kimdeath.configuration;

import org.springframework.cloud.client.loadbalancer.LoadBalanced;
import org.springframework.cloud.netflix.ribbon.RibbonClient;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.client.RestTemplate;

/**
 * @author issuser
 * ConfigRibbon 注意不能放到和@ComponentScan统一个包 下否则会扫描 覆盖,
 * PS:@SpringBootApplication中包含@ComponentScan 因此该类不也能和启动类一个包
 * spring-cloud-file-system 是当前服务实例名称信息
 * 
 * 本项目采用 是通过注解过滤扫描过程中 同包覆盖的问题 
 * @ComponentScan(excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,value=RulesExcludeRibbon.class)})
 * @see com.kimdeath.configuration.RibbonRublesConfig 规则位置添加过滤注解
 * @see com.kimdeath.RibbonApplication 
 */
@Configuration
@RibbonClient(name = "spring-cloud-file-system", configuration = RibbonRublesConfig.class)
public class RibbonConfiguration {
	@Bean
	@LoadBalanced//Ribbon 客户端负载均衡
	public RestTemplate restTemplate(){
		return new RestTemplate();
	}
	
}
