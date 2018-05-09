package com.kimdeath.api.Hystrix;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.kimdeath.configuration.FeginConfiguration;
import com.kimdeath.configuration.Hystrix.HystrixMethodFallbackConfiguartion;
import com.kimdeath.domain.ApplicationDTO;

import feign.Param;
import feign.RequestLine;

/**
 * 
 * @author issuser
 *
 */
@FeignClient(value="spring-cloud-model",fallback=HystrixMethodFallbackConfiguartion.class,configuration=FeginConfiguration.class)
public interface IModeClient {
	
	@RequestLine("GET /queryApplications")
	public List<ApplicationDTO> queryApplications();
	
	@RequestLine("GET /queryApplicationsSigle")
	public ApplicationDTO queryApplicationsSigle();
	
	@RequestLine("POST /queryParams")
	public String queryParams(String ids);
}
