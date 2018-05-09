package org.spring.cloud.common.web.result;

import java.util.List;


/**
 * <p>Description:泛型处理方法</p>
 * @author chenjl
 * @date 2017-03-06
 * @version 1.0
 * 
 */
public class ResponseGenericityHandler<T> {
	
	private static final String RES_SUCCESS="请求成功";
	private static final String RES_FAILED="请求失败";
	/**
	 * 不带分页的数据列表
	 * @param code
	 * @param result
	 * @return
	 */
	public  ResponseResult setLData(String code,List<T> result) {
		ResponseGenericityData<T> resultData=new ResponseGenericityData<T>();
		resultData.setCode(code);
		resultData.setResultlist(result);
		resultData.setMessage(handleCode(code));
		return resultData;
	}
	
	/**
	 *  带分页的数据列表
	 * @param code
	 * @param total
	 * @param result
	 * @return
	 */
	public  ResponseResult setPLData(String code,long total,List<T> result) {
		ResponseGenericityData<T> resultData=new ResponseGenericityData<T>();
		resultData.setCode(code);
		resultData.setTotal(total);
		resultData.setResultlist(result);
		resultData.setMessage(handleCode(code));
		return resultData;
	}
	
	/**
	 *  带分页的数据对象
	 * @param code
	 * @param total
	 * @param result
	 * @return
	 */
	public  ResponseResult setOPData(String code,long total,T Object) {
		ResponseGenericityData<T> resultData=new ResponseGenericityData<T>();
		resultData.setCode(code);
		resultData.setTotal(total);
		resultData.setResultObject(Object);
		resultData.setMessage(handleCode(code));
		return resultData;
	}
	
	/**
	 *  不带分页的数据对象
	 * @param code
	 * @param total
	 * @param result
	 * @return
	 */
	public  ResponseResult setOData(String code,T Object) {
		ResponseGenericityData<T> resultData=new ResponseGenericityData<T>();
		resultData.setCode(code);
		resultData.setResultObject(Object);
		resultData.setMessage(handleCode(code));
		return resultData;
	}
	/**
	 *  不带分页的数据对象
	 * @param code
	 * @param total
	 * @param result
	 * @return
	 */
	public  ResponseResult setNData(String code,String message) {
		ResponseGenericityData<T> resultData=new ResponseGenericityData<T>();
		resultData.setCode(code);
		resultData.setMessage(message);
		return resultData;
	}
	private String handleCode(String code){
		if(code.equals("0")){
			return RES_SUCCESS;
		}
		return RES_FAILED;
	}
	
}
