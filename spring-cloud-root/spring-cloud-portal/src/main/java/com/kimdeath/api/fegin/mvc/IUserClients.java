
package com.kimdeath.api.fegin.mvc;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.kimdeath.domain.ApplicationDTO;

import feign.RequestLine;

/**
 * FeginClient mvc常用配置
 * 
 * @author issuser
 *
 */
@FeignClient(value = "spring-cloud-user")
public interface IUserClients {

	@RequestMapping(value = "/user/queryApplications", method = RequestMethod.GET)
	public List<ApplicationDTO> queryApplicationsMVC();

	@RequestMapping(value = "/user/querySingleApplications", method = RequestMethod.GET)
	public ApplicationDTO querySingleApplicationsMVC();

}
