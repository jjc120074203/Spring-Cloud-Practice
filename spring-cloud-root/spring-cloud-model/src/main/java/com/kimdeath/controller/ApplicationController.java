package com.kimdeath.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import com.isoftstone.cityinsight.result.ResponseGenericityHandler;
import com.kimdeath.domain.ApplicationDTO;
import com.kimdeath.service.ApplicationService;
import com.netflix.discovery.EurekaClient;

@RestController
public class ApplicationController {
	private static Log logger=LogFactory.getLog(ApplicationController.class);
	@Autowired
	private EurekaClient discoveryClient;
	@Autowired
	private ApplicationService applicationService;

	
	@GetMapping("/queryApplications")
    public List<ApplicationDTO> queryApplications() {
    	ResponseGenericityHandler<ApplicationDTO> res= new ResponseGenericityHandler<ApplicationDTO>();
    	long startTime=System.currentTimeMillis();   //获取开始时间
    	ArrayList<ApplicationDTO> list=applicationService.getAllApplication();
    	long endTime=System.currentTimeMillis();   //获取结束时间
    	return list;
    }
	
	@GetMapping("/queryApplicationsSigle")
    public ApplicationDTO queryApplicationsSigle() {
    	ResponseGenericityHandler<ApplicationDTO> res= new ResponseGenericityHandler<ApplicationDTO>();
    	long startTime=System.currentTimeMillis();   //获取开始时间
    	ArrayList<ApplicationDTO> list=applicationService.getAllApplication();
    	long endTime=System.currentTimeMillis();   //获取结束时间
    	return list.get(0);
    }
	
	@PostMapping("/queryParams")
	public String queryParams(String ids){
		return "SUCCESS";
	}
}
