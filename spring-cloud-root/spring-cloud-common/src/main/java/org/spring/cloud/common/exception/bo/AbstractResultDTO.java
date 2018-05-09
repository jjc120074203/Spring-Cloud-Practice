package org.spring.cloud.common.exception.bo;

public class AbstractResultDTO<T> {
	private boolean ExpFlag;
	private ErrorMessageInfoBO ErrorMessageInfoBO;
	public boolean isExpFlag() {
		return ExpFlag;
	}
	public void setExpFlag(boolean expFlag) {
		ExpFlag = expFlag;
	}
	public ErrorMessageInfoBO getErrorMessageInfoBO() {
		return ErrorMessageInfoBO;
	}
	public void setErrorMessageInfoBO(ErrorMessageInfoBO errorMessageInfoBO) {
		ErrorMessageInfoBO = errorMessageInfoBO;
	}
	
}
