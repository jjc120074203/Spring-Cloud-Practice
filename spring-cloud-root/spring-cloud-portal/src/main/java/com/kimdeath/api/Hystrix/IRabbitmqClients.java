package com.kimdeath.api.Hystrix;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;

import com.kimdeath.configuration.FeginConfiguration;
import com.kimdeath.configuration.Hystrix.HystrixMessageFallbackConfiguartion;
import com.kimdeath.domain.ApplicationDTO;

import feign.RequestLine;

/**
 * 采用默认Fegin 配置
 * 同时配置 fallbackFactory 
 * @author issuser
 *
 */
@FeignClient(value="spring-cloud-model",fallbackFactory = HystrixMessageFallbackConfiguartion.class,configuration=FeginConfiguration.class)
public interface IRabbitmqClients {
    
	@RequestLine("GET /queryApplications")
	public List<ApplicationDTO> queryApplicationFallBackFactory();
}
