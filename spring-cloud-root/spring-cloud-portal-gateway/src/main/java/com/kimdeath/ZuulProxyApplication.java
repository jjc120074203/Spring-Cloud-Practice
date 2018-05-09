package com.kimdeath;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.zuul.EnableZuulProxy;

@EnableZuulProxy
@SpringBootApplication
public class ZuulProxyApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(ZuulProxyApplication.class).web(true).run(args);
	}

	// #文件1
	// 正则表达式路由组     name: spring-cloud-file-system-v1   访问的时候就是v1/spring-cloud-file-system/接口
//	@Bean
//	public PatternServiceRouteMapper serviceRouteMapper() {
//		return new PatternServiceRouteMapper("(?<name>^.+)-(?<version>v.+$)", "${version}/${name}");
//	}
}
