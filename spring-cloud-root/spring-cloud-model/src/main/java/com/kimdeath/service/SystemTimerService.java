package com.kimdeath.service;

import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.isoftstone.cityinsight.utils.CommonTools;
import com.kimdeath.dao.SystemTimerMapper;
import com.kimdeath.domain.SystemTimer;

@Service
public class SystemTimerService {
	@Autowired
  private SystemTimerMapper systemTimerMapper;
	
	public SystemTimer querySystemTimerByName(String sysType,String targetMethod,String targetClass){
		Map<String, Object> param=new HashMap<String, Object>();
		param.put("targetMethod", targetMethod);
		param.put("targetClass", targetClass);
		param.put("sysType", sysType);
		return systemTimerMapper.querySystemTimerByName(param);
	}
	public  Integer saveSystemTimer(SystemTimer systemTimer){
		systemTimer.setId(CommonTools.generateShortUuid());
		return systemTimerMapper.saveSystemTimer(systemTimer);
	}
}
