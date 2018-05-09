package com.kimdeath.service;

import org.spring.cloud.common.exception.ServiceException;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.kimdeath.dao.SystemToolsMapper;

@Component
public class SystemToolsService {

    @Autowired
    private SystemToolsMapper systemToolsMapper;
    
    /**
	 * 获取系统参数msg
	 * @param paramCode
	 * @return
	 */
	public String getExpMessage(String paramCode) throws ServiceException{
		return systemToolsMapper.getMessage(paramCode);
	}
	
}
