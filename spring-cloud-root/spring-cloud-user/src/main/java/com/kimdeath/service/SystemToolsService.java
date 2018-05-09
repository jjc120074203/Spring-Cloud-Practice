package com.kimdeath.service;

import org.spring.cloud.common.exception.DataTransfromException;
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
     * @throws DataTransfromException 
	 */
	public String getExpMessage(String paramCode) throws ServiceException, DataTransfromException{
		return systemToolsMapper.getMessage(paramCode);
	}
	
}
