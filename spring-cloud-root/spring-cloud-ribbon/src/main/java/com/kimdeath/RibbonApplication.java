package com.kimdeath;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.FilterType;

import com.kimdeath.configuration.RulesExcludeRibbon;

@SpringBootApplication
@EnableEurekaClient
@ComponentScan(excludeFilters={@ComponentScan.Filter(type=FilterType.ANNOTATION,value=RulesExcludeRibbon.class)})
public class RibbonApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(RibbonApplication.class).web(true).run(args);
	}
}
