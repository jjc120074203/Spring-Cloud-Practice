package com.kimdeath.controller;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.kimdeath.api.Hystrix.IModeClient;
import com.kimdeath.api.Hystrix.IRabbitmqClients;
import com.kimdeath.api.fegin.orgin.IUserClient;
import com.kimdeath.domain.ApplicationDTO;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import com.netflix.hystrix.contrib.javanica.annotation.HystrixProperty;

/**
 * 配置Hystix 两个前提条件：
 * 1.启动类添加@EnableCircuitBreaker //Hystrix 熔断器注解
 * 2.配置yaml 
 * feign:
 *  hystrix:
 *   enabled: true 
 * 
 * @author issuser
 *
 */
@RestController
public class HystrixController {
	@Autowired
	public IUserClient IUserClient;
	@Autowired
	public IModeClient IModeClient;
	@Autowired
	public IRabbitmqClients IRabbitmqClients;
	
	/**
	 * @HystrixCommand 熔断器回调 接口 失败回调failedMethod方法
	 * 失败包括两种情况 底层无法响应 或者 存在响应但是响应超时
	 * @return
	 */
	@GetMapping("/hystrix/queryApplications")
	@HystrixCommand(fallbackMethod = "failedMethod")
    public List<ApplicationDTO> queryApplications() {
		return IUserClient.queryApplications();
	}
	
	/**
	 * 该方法 高并发的时候为了避免线程 上下文安全，设置访问策略 
	 * @HystrixCommand 
	 *  thread 使用一个线程隔离当前请求线程，并发请求接受线程池中的线程数量的限制[默认设置]
	 *	semaphore 它在调用的线程上执行 并发请求收到信号计量的限制
	 */
	@GetMapping("/hystrix/queryApplicationstategate")
	@HystrixCommand(fallbackMethod="failedMethod",commandProperties={@HystrixProperty(name="execution.isolation.strategy", value="SEMAPHORE")})
	public List<ApplicationDTO> queryApplicationstategate(){
		return IUserClient.queryApplications();
	}
	
	/**
	 * 通过Fegin 配置熔断器
	 * @return
	 */
	@GetMapping("/hystrix/queryApplicationsFegin")
	public List<ApplicationDTO> queryApplicationsFegin(){
		return IModeClient.queryApplications();
	}
	
	
	
	/**
	 * 通过Fegin-Factory 配置熔断器
	 * @return
	 */
	@GetMapping("/hystrix/queryApplicationFallBackFactory")
	public List<ApplicationDTO> queryApplicationFallBackFactory(){
		return IRabbitmqClients.queryApplicationFallBackFactory();
	}
	/*****************************************************/
	/**
	 *  Hystrix失败回调方法
	 * @return
	 */
	public List<ApplicationDTO> failedMethod(){
		ApplicationDTO ad=new ApplicationDTO();
		ad.setAppName("方法熔断器回调");
		ad.setAppId("E00000000000000000000001");
		List list=new ArrayList<ApplicationDTO>();
		list.add(ad);
		return list;
	}
	
	@GetMapping("/queryParams")
	public String queryParams(String res){
	return	IModeClient.queryParams(res);
	}
	
}
