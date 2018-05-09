package org.spring.cloud.common.exception;

import org.spring.cloud.common.exception.bo.ErrorMessageInfoBO;

public class AbstractException extends Exception {

	private static final long serialVersionUID = -6972426612451583492L;
	private String MessageKey;
	private Throwable StackMessage;
	private Object[] args;
	private ErrorMessageInfoBO errorMessageInfoBO;
	

	public Throwable getStackMessage() {
		return StackMessage;
	}

	public void setStackMessage(Throwable stackMessage) {
		StackMessage = stackMessage;
	}

	public String getMessageKey() {
		return MessageKey;
	}

	public void setMessageKey(String messageKey) {
		MessageKey = messageKey;
	}

	public Object[] getArgs() {
		return args;
	}

	public void setArgs(Object[] args) {
		this.args = args;
	}

	
	public AbstractException(String code, String message, Object[]args, Throwable cause) { 
		this.errorMessageInfoBO.setErrorCode(code);
		this.errorMessageInfoBO.setErrorReason(message);
		this.errorMessageInfoBO.setArgs(args);
		this.errorMessageInfoBO.setErrorData(cause);
       
    } 
	public AbstractException(String code,  Object[]args ,String message) {
		this.errorMessageInfoBO.setErrorCode(code);
		this.errorMessageInfoBO.setErrorReason(message);
		this.errorMessageInfoBO.setArgs(args);
	       
    } 
	public AbstractException(String code, String message, Throwable cause) { 
		this.errorMessageInfoBO.setErrorCode(code);
		this.errorMessageInfoBO.setErrorReason(message);
		this.errorMessageInfoBO.setErrorData(cause);
	       
    } 
	public AbstractException(String code, String message) {  
		this.errorMessageInfoBO.setErrorCode(code);
		this.errorMessageInfoBO.setErrorReason(message);
		this.errorMessageInfoBO.setArgs(args);
	       
    } 
	
}
