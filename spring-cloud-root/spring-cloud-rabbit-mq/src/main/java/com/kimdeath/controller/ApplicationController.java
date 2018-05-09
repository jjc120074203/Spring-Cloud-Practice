package com.kimdeath.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.cloud.common.exception.DataTransfromException;
import org.spring.cloud.common.web.result.ResponseGenericityHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

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
    public List<ApplicationDTO> queryApplications() throws DataTransfromException {
    	ResponseGenericityHandler<ApplicationDTO> res= new ResponseGenericityHandler<ApplicationDTO>();
    	long startTime=System.currentTimeMillis();   //获取开始时间
    	ArrayList<ApplicationDTO> list=applicationService.getAllApplication();
    	long endTime=System.currentTimeMillis();   //获取结束时间
    	return list;
    }
}
