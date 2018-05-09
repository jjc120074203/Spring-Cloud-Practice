package com.kimdeath.domain;

import java.io.Serializable;
import java.util.Date;

/**
 * @author issuser
 *
 */
public class SystemTimer implements Serializable {
	private static final long serialVersionUID = -7950103783522127436L;
	private String id;
	private String targetMethod;
	private String targetClass;
	private String cronExpression;
	private String sysType;
	private Integer timerRank;
	private Date created_at;

	public Integer getTimerRank() {
		return timerRank;
	}

	public void setTimerRank(Integer timerRank) {
		this.timerRank = timerRank;
	}

	public String getId() {
		return id;
	}

	public void setId(String id) {
		this.id = id;
	}

	public String getTargetMethod() {
		return targetMethod;
	}

	public void setTargetMethod(String targetMethod) {
		this.targetMethod = targetMethod;
	}

	public String getTargetClass() {
		return targetClass;
	}

	public void setTargetClass(String targetClass) {
		this.targetClass = targetClass;
	}

	public String getCronExpression() {
		return cronExpression;
	}

	public void setCronExpression(String cronExpression) {
		this.cronExpression = cronExpression;
	}

	public String getSysType() {
		return sysType;
	}

	public void setSysType(String sysType) {
		this.sysType = sysType;
	}

	public Date getCreated_at() {
		return created_at;
	}

	public void setCreated_at(Date created_at) {
		this.created_at = created_at;
	}

}
