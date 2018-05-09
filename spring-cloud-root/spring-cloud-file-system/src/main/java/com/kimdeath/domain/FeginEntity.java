
package com.kimdeath.domain;

import java.io.Serializable;

public class FeginEntity implements Serializable{
	private static final long serialVersionUID = 1087274391105877262L;
	private String feginId;
	private String feginName;
	private String feginCreatedBy;
	public String getFeginId() {
		return feginId;
	}
	public void setFeginId(String feginId) {
		this.feginId = feginId;
	}
	public String getFeginName() {
		return feginName;
	}
	public void setFeginName(String feginName) {
		this.feginName = feginName;
	}
	public String getFeginCreatedBy() {
		return feginCreatedBy;
	}
	public void setFeginCreatedBy(String feginCreatedBy) {
		this.feginCreatedBy = feginCreatedBy;
	}
}