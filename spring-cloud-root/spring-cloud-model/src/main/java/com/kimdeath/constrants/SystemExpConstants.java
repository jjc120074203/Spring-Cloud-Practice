package com.kimdeath.constrants;

import java.io.Serializable;

/**
 * 异常代码库（数据访问层 异常不按照功能区分）
 *  @description  
 *  <h1>错误码异常规范</h1></br>
 *  <ul>
 *  	<li>错误码需要编写翻译错误码信息注释 </li>
 *  	<li>新增模块划分体系时，需要新增内部类 </li>
 *  	<li>错误码规则 E+模块码位+7位流水号 例如 ：E10000000</li>
 *  	<li>模块码位：1  目前表示  svc-user 数据访问层错误 （若有增加码位：1-9svc-xxx） </li>
 *  	<li>变量定义规则: 模块名称_错误码信息(不建议拼音，长句，变量大写)）</li>
 *  
 *  </ul>
 * @author chenjl 
 * @since 2017-2-13
 * @version 1.0
 *
 */
public final  class SystemExpConstants implements Serializable{
	
	private static final long serialVersionUID = 3682414473827689061L;

	/**
	 * common异常模块
	 *
	 **/
	public static final class common {
		// 数据访问层出现异常
		public final static String USER_DATA_MODEL_SYSTEM_ERROR = "E10000000";
		// 数据访问层出现异常
		public final static String USER_DATA_SYSTEM_ERROR = "E10000002";
		// 错误码未匹配到对应的信息
		public final static String USER_CODE_NOT_FOUND_ERROR = "E10000001";
		// 未知异常
		public final static String USER_UNKNOWN_SYSTEM_ERROR = "E10000003";
		
	}

	/**
	 * 
	 * 用户格式校验类异常 2
	 *
	 */
	public static final class valivation {
		
	// 用户校验异常
	public final static String USER_TYPE_IS_ERROR = "E20000000";
	}
	 

}
