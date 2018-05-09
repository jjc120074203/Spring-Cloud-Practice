
package com.kimdeath.api.fegin.orgin;

import java.util.List;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.multipart.MultipartFile;

import com.kimdeath.configuration.FeginConfiguration;
import com.kimdeath.domain.ApplicationDTO;

import feign.Param;
import feign.RequestLine;

/**
 * FeginClient 默认配置
 * @author issuser
 *
 */
@FeignClient(value="spring-cloud-user",configuration=FeginConfiguration.class)
public interface IUserClient {
	
	  @RequestLine("GET /user/queryApplications")
	  public List<ApplicationDTO> queryApplications();
	  
	  @RequestLine("GET /user/querySingleApplications")
	  public ApplicationDTO querySingleApplications();
	  
	 
}
