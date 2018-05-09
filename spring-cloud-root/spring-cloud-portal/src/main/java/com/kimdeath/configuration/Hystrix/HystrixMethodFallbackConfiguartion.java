package com.kimdeath.configuration.Hystrix;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Component;

import com.kimdeath.api.Hystrix.IModeClient;
import com.kimdeath.domain.ApplicationDTO;


//Fegin 为每个方法设置熔断器，设置返回错误请求
@Component
public class HystrixMethodFallbackConfiguartion implements IModeClient{

	@Override
	public List<ApplicationDTO> queryApplications() {
		List<ApplicationDTO> list=new ArrayList<ApplicationDTO>();
		ApplicationDTO res=new ApplicationDTO();
		res.setAppName("接口实现熔断器回调进入熔断器逻辑");
		res.setAppVersion("2222222222222222222");
		list.add(res);
		return list;
	}

	@Override
	public String queryParams(String ids) {
		// TODO Auto-generated method stub
		return "000000000000";
	}

	@Override
	public ApplicationDTO queryApplicationsSigle() {
		// TODO Auto-generated method stub
		return null;
	}

	}