package org.spring.cloud.common.exception;

public class DataTransfromException extends ServiceException{
	
	public DataTransfromException(String code, Object[] args, String message) {
		super(code, args, message);
	}
	public DataTransfromException(String code, String message, Object[]args, Throwable cause) {
		super(code, message,args, cause);
	}
	public DataTransfromException(String code, String message, Throwable cause) {
		super(code, message, cause);
	}
	public DataTransfromException(String code, String message) {
		super(code, message);
	}
}
