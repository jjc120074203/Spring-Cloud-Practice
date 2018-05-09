package com.kimdeath.controller;

import java.io.IOException;
import java.io.InputStream;
import java.util.HashMap;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.hibernate.validator.internal.engine.messageinterpolation.el.MapBasedFunctionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.multipart.MultipartFile;

import com.netflix.appinfo.InstanceInfo;
import com.netflix.discovery.EurekaClient;

@RestController
public class EurekaController {
	private static Log logger=LogFactory.getLog(EurekaController.class);
	@Autowired
	private EurekaClient discoveryClient;

	
	@GetMapping("/hello")
	public String testHelloWorld(){
		logger.info("[MQ]testHelloWorld");
		return "Nice to meet you ~[MQ]testHelloWorld";
	}
	@GetMapping("/testEurekaClient")
	public String testEurekaClient(String name){
		    InstanceInfo instance = discoveryClient.getNextServerFromEureka(name, false);
		    return instance.getHomePageUrl();
	}
	
	@PostMapping("/uploadFile")
	public int uploadFile(@RequestParam("file")InputStream file) throws IOException{
		return file.available();
	}
}
