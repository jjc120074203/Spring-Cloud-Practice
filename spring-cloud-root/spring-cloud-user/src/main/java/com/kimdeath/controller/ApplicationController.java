package com.kimdeath.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.cloud.common.exception.DataTransfromException;
import org.spring.cloud.common.web.auth.AuthUser;
import org.spring.cloud.common.web.auth.AuthUserContext;
import org.spring.cloud.common.web.result.ResponseGenericityHandler;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kimdeath.configuration.auth.IAMOAuth2Token;
import com.kimdeath.domain.ApplicationDTO;
import com.kimdeath.service.ApplicationService;
import com.netflix.discovery.EurekaClient;

import io.swagger.annotations.ApiOperation;

@RestController
public class ApplicationController {
	private static Log logger=LogFactory.getLog(ApplicationController.class);
	@Autowired
	private EurekaClient discoveryClient;
	@Autowired
	private ApplicationService applicationService;

	@ApiOperation(value="获取应用新信息")
	@GetMapping("/user/queryApplications")
    public List<ApplicationDTO> queryApplications() throws DataTransfromException {
//		logger.info("++++++++++++++++++++++++++++++++++++++");
    	ResponseGenericityHandler<ApplicationDTO> res= new ResponseGenericityHandler<ApplicationDTO>();
    	long startTime=System.currentTimeMillis();   //获取开始时间
    	ArrayList<ApplicationDTO> list=applicationService.getAllApplication();
    	long endTime=System.currentTimeMillis();   //获取结束时间
    	return list;
    }
	
	@ApiOperation(value="获取应用新信息-单个")
	@GetMapping("/user/querySingleApplications")
    public ApplicationDTO querySingleApplications() throws DataTransfromException {
    	ResponseGenericityHandler<ApplicationDTO> res= new ResponseGenericityHandler<ApplicationDTO>();
    	long startTime=System.currentTimeMillis();   //获取开始时间
    	ArrayList<ApplicationDTO> list=applicationService.getAllApplication();
    	long endTime=System.currentTimeMillis();   //获取结束时间
    	return list.get(0);
    }
	
	@ApiOperation(value="登录信息")
	@GetMapping("/user/login")
	public String login() {
		
		 IAMOAuth2Token token =new IAMOAuth2Token();
		 token.setAccessToken("326e4d47-7c68-4ffb-8443-0cf0e1fea608");
		 AuthUser authUser = new AuthUser();
		 authUser.setId("1");
		 authUser.setName("123456789");
		
		AuthUserContext ctx = AuthUserContext.getContext();
		ctx.setAuthUser(authUser);
		ctx.setAuthToken(token);
		return token.getAccessToken();
	}
}
