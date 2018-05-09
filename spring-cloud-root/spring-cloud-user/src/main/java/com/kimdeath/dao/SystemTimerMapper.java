package com.kimdeath.dao;

import java.util.Map;

import com.kimdeath.domain.SystemTimer;

public interface SystemTimerMapper {
	public SystemTimer querySystemTimerByName(Map<String, Object> param);
	public  Integer saveSystemTimer(SystemTimer systemTimer);
}
