package com.kimdeath.api.fegin.orgin;

import java.util.List;
import java.util.Map;

import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.kimdeath.configuration.FeginConfiguration;
import com.kimdeath.domain.FeginEntity;

import feign.Body;
import feign.Param;
import feign.RequestLine;

/**
 * 采用Fegin默认注解
 * 
 * 如果不加configuration 配置的话，采用的spring-mvc 注解方式
 * @author issuser
 *
 */
@FeignClient(value="spring-cloud-file-system",configuration=FeginConfiguration.class)
public interface IFileSystemClient {

	//Fegin mvc 模式 @GetMapping 不支持  和@@PathVariable 需要指定 value
//	@RequestMapping(value="/hello",method=RequestMethod.GET)
//	public String testHelloWorld();
//	
//	@RequestMapping(value="/getEurekaClient",method=RequestMethod.POST)
//	public String getEurekaClient(@PathVariable("id")String id);
	
	@RequestLine("POST /getEurekaClient")
	public String getEurekaClient(@Param("id")String id);
	@RequestLine("GET /hello")
	public String testHelloWorld();

//	@RequestLine("POST /file/UploadSinglefile")
//	public String UploadSinglefile(@RequestParam(name="file")MultipartFile file, FeginEntity FeginEntity);
//	
//	@PostMapping("POST /file/UploadMultifiles")
//	public Map<String,Object> UploadMultifiles(String folder,@RequestParam(name="file")MultipartFile[] files,FeginEntity FeginEntity);
//	
	
}
