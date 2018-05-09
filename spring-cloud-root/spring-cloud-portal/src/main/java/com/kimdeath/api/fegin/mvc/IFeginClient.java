package com.kimdeath.api.fegin.mvc;

import java.io.IOException;
import java.io.InputStream;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimdeath.configuration.FeginAuthConfiguation;

import feign.Param;

/**
 * 
 * MQ fegin采用 Spring-mvc 的注解
 * @author issuser
 * @FeignClient 使用方法
 *  1.@FeignClient(value="实例名称)
 *  2.@FeignClient(value="实例名称,url="指向需要访问的本地实例")
 *  3.@FeignClient(name="xxxx",url="注册中心地址")
 *  	3.1 访问的时候 @RequestMapping(value="/eureka/apps/实例名称",method=RequestMethod.GET)
 *  		注册中心地址+/eureka/apps/实例名称 :访问的是注册中心 实例的信息 name 只是别名
 *PS:本项目采用第三种方法    由于 注册中心配置了账户密码 采用第三种访问方式的话，需要手动配置fegin
 */
@FeignClient(name="xxxxx",url="localhost:1240",configuration=FeginAuthConfiguation.class)//当存在Url 时候 name 就是单独起别名 ，没有的Url 需要填写client名称
public interface IFeginClient {

	
	@RequestMapping(value="/eureka/apps/spring-cloud-user",method=RequestMethod.GET)
	public String testFeginByPassWord();

	
}
