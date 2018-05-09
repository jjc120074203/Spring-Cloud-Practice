package org.spring.cloud.common.exception;

public class ServiceException extends AbstractException{
	private static final long serialVersionUID = -952104276921501332L;
	public ServiceException(String code, Object[] args, String message) {
		super(code, args, message);
	}
	public ServiceException(String code, String message, Object[]args, Throwable cause) {
		super(code, message,args, cause);
	}
	public ServiceException(String code, String message, Throwable cause) {
		super(code, message, cause);
	}
	public ServiceException(String code, String message) {
		super(code, message);
	}

}
