package com.kimdeath.dao;

import com.isoftstone.cityinsight.exception.type.DataTransfromException;

public interface SystemToolsMapper {
	/**
	 * 获取系统参数msg
	 * @param paramCode
	 * @return
	 */
	public String getMessage(String  paramCode) throws DataTransfromException;
}
