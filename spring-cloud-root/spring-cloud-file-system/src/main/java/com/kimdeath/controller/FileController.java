package com.kimdeath.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.kimdeath.domain.FeginEntity;
import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class FileController {
	private static Log logger=LogFactory.getLog(FileController.class);
	@Autowired
	private EurekaClient discoveryClient;

	
	@GetMapping("/hello")
	public String testHelloWorld(){
		logger.info("Nice to meet you ~");
		return "Nice to meet you ~";
	}
	
	@GetMapping("/testEurekaClient")
	public String testEurekaClient(String name){
		    InstanceInfo instance = discoveryClient.getNextServerFromEureka(name, false);
		    return instance.getHomePageUrl();
	}
}
