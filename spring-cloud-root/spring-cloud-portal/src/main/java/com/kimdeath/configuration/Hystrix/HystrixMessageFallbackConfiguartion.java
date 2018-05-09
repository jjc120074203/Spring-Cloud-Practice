package com.kimdeath.configuration.Hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kimdeath.api.Hystrix.IRabbitmqClients;
import com.kimdeath.domain.ApplicationDTO;

import feign.hystrix.FallbackFactory;


//Fegin 为每个方法设置统一返回结果
@Component
public class HystrixMessageFallbackConfiguartion implements FallbackFactory<IRabbitmqClients>{

	@Override
	public IRabbitmqClients create(Throwable cause) {
		return new IRabbitmqClients(){
			@Override
			public List<ApplicationDTO> queryApplicationFallBackFactory() {
				List<ApplicationDTO> list=new ArrayList<ApplicationDTO>();
				ApplicationDTO res=new ApplicationDTO();
				res.setAppName("进入Factory熔断器逻辑");
				res.setAppVersion("11111111111111111");
				list.add(res);
				return list;
			}
			
		};
	}
}