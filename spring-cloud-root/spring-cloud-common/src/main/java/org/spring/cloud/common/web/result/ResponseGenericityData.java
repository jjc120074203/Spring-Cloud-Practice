package org.spring.cloud.common.web.result;

import java.util.List;

/**
 *  返回数据对象是一个泛型
 * @author jlchenq
 *
 */
public class ResponseGenericityData <T> extends ResponseResult{
	private long total; //分页页码
	private String code; //返回码
	private String message; //返回码
	private List <T> resultlist;  // 结果集列表
	private T resultObject;  // 解决集对象
	
	public long getTotal() {
		return total;
	}
	public void setTotal(long total) {
		this.total = total;
	}
	public List<T> getResultlist() {
		return resultlist;
	}
	public void setResultlist(List<T> resultlist) {
		this.resultlist = resultlist;
	}
	public T getResultObject() {
		return resultObject;
	}
	public void setResultObject(T resultObject) {
		this.resultObject = resultObject;
	}
	public String getCode() {
		return code;
	}
	public void setCode(String code) {
		this.code = code;
	}
	public String getMessage() {
		return message;
	}
	public void setMessage(String message) {
		this.message = message;
	}
}
