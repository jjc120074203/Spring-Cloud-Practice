package com.kimdeath.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
public class RibbonController {

	@Autowired
	private RestTemplate rest;
	
	
	@GetMapping("/helloRibbon")
	public String  HelloRibbon(String name){
//		spring-cloud-file-system VIP [virtual IP]  -HA proxy | heart beat
		return rest.getForObject("http://spring-cloud-file-system/testEurekaClient?name="+name, String.class);
	}
	
	@GetMapping("/hello")
	public String hello(){
		return rest.getForObject("http://spring-cloud-file-system//hello", String.class);
	}
}
