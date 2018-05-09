package org.spring.cloud.common.exception.bo;

import java.io.Serializable;
import java.util.Date;

public class ErrorMessageInfoBO implements Serializable{

	private static final long serialVersionUID = 6301159282378139026L;
private String ErrorCode;
 private String ErrorReason;
 private Object[] args;
 private Throwable ErrorData;
 private Date CreateTime;
 
 
 
public Object[] getArgs() {
	return args;
}
public void setArgs(Object[] args) {
	this.args = args;
}
public String getErrorCode() {
	return ErrorCode;
}
public void setErrorCode(String errorCode) {
	ErrorCode = errorCode;
}
public String getErrorReason() {
	return ErrorReason;
}
public void setErrorReason(String errorReason) {
	ErrorReason = errorReason;
}

public Throwable getErrorData() {
	return ErrorData;
}
public void setErrorData(Throwable errorData) {
	ErrorData = errorData;
}
public Date getCreateTime() {
	return CreateTime;
}
public void setCreateTime(Date createTime) {
	CreateTime = createTime;
}
 
}
