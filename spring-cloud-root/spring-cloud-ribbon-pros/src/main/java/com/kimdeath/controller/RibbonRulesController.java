package com.kimdeath.controller;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.loadbalancer.LoadBalancerClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.netflix.loadbalancer.IRule;

/**
 * @author issuser
 * 测试Ribbon 负载均衡 策略测试
 */
@RestController
public class RibbonRulesController {
	private static Log logger=LogFactory.getLog(RibbonRulesController.class);
	@Autowired
	private LoadBalancerClient lbc;
	
	/**
	 * 由于spring-cloud-file-system 配置RandomRules()
	 * 访问次数是随机的
	 * @see com.config.RibbonRublesConfig.java
	 * 
	 * 由于spring-cloud-file-system-bak 未配置Rules
	 * 访问 是roundRobin 顺序的
	 * @return
	 */
	
	@GetMapping("/testRules")
	public boolean testRules(){
		//选择服务实例
		ServiceInstance si=lbc.choose("spring-cloud-file-system");
		logger.info("$-"+si.getServiceId()+si.getHost()+":"+si.getPort());
		logger.info("-----------------------------------------------------");
		ServiceInstance sis=lbc.choose("spring-cloud-file-system-bak");
		logger.info("￥-"+sis.getServiceId()+sis.getHost()+":"+sis.getPort());
		return false;
	}
}
