package com.kimdeath.domain;

import java.io.Serializable;
import java.util.Date;

public class TestDockerInfo implements Serializable{
	private static final long serialVersionUID = 7530193744792018987L;
	private String  redisId; 
	private String  redisName; 
	private String  redisMark; 
	private Date dataCreateTime;
	public String getRedisId() {
		return redisId;
	}
	public void setRedisId(String redisId) {
		this.redisId = redisId;
	}
	public String getRedisName() {
		return redisName;
	}
	public void setRedisName(String redisName) {
		this.redisName = redisName;
	}
	public String getRedisMark() {
		return redisMark;
	}
	public void setRedisMark(String redisMark) {
		this.redisMark = redisMark;
	}
	public Date getDataCreateTime() {
		return dataCreateTime;
	}
	public void setDataCreateTime(Date dataCreateTime) {
		this.dataCreateTime = dataCreateTime;
	} 
}
