package com.kimdeath.constrants;

/**
 * 系统常量池
 * @author chenjl
 * @version v0.9
 * 
 *
 */
public final class SystemConstrants {

	//系统参数池{用户参数池}
	public static final class params {
		//数据访问层出现异常
		public final static String USER_PARAMS_SVC_USER = "svc-user";
	}

	// 字段返回值
	public static final class returnCode {
		// 返回失败
		public final static Boolean USER_RETURNCODE_N = false;
		// 返回成功
		public final static Boolean USER_RETURNCODE_Y = true;
	}
}
