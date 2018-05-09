package com.kimdeath.exception;

import java.util.Date;
import java.util.Locale;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.spring.cloud.common.exception.bo.AbstractResultDTO;
import org.spring.cloud.common.exception.bo.ErrorMessageInfoBO;
import org.spring.cloud.common.utils.CommonTools;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.kimdeath.constrants.SystemConstrants;
import com.kimdeath.constrants.SystemExpConstants;
import com.kimdeath.service.SystemToolsService;

/**
 * 异常处理报文结构
 * @author chenjl
 * @since 2017-2-24
 * @version 2017-2-24
 * @param <T>
 * @deprecated 改程序已经废弃 待删除
 */
@Component
public class ExceptionTools<T> {
	private final static Log logger=LogFactory.getLog(ExceptionTools.class);
	
	@Autowired
	private LocaleMessageSourceResolver LocaleMessageSourceResolver; //国际化解析器 todo
	
	@Autowired
	private  SystemToolsService systemToolsService;

    @Value("${msg.sys_props_switch}")
    private  String sys_props_switch;
	
	 public   AbstractResultDTO <T> HandleException(Exception ae,T a){
		 Locale locale = LocaleContextHolder.getLocale();//获取区域信息
			String switchFlag=sys_props_switch;
			ErrorMessageInfoBO errorMessage=new ErrorMessageInfoBO();
			AbstractResultDTO<T> errorMessageResult=new AbstractResultDTO<T>();
			errorMessage.setErrorCode(SystemExpConstants.common.USER_DATA_MODEL_SYSTEM_ERROR);
			errorMessage.setErrorReason(HandleErrorCode(errorMessage,switchFlag,locale));	
//			errorMessage.setErrorData(ae.getMessage());
			errorMessage.setCreateTime(new Date());
			errorMessageResult.setExpFlag((SystemConstrants.returnCode.USER_RETURNCODE_N));
//			errorMessageResult.setErrorMessage(errorMessage);
			return errorMessageResult;
	  }
	 /**
		 *  处理异常错误码信息
		 * @param errorMessage
		 * @param code
		 * @param ae
		 * @param locale
		 * @return
		 * @throws Exception
		 */
		private String HandleErrorCode(ErrorMessageInfoBO errorMessage ,String code,Locale locale){
			try {
				switch (code) {
				case "1":
					 //读取参数以本地参数文件为准*.properties
					return LocaleMessageSourceResolver.getMessage(errorMessage.getErrorCode(),new Object[]{SystemConstrants.params.USER_PARAMS_SVC_USER},locale);
				case "2":
					//获取参数以数据库参数为准  
					return systemToolsService.getExpMessage(errorMessage.getErrorCode());
				case "3":
					// 获取先根据本地参数文件然后根据数据库
					String msgReson="";
					if((CommonTools.isNullOrEmpty(LocaleMessageSourceResolver.getMessage(errorMessage.getErrorCode(),new Object[]{SystemConstrants.params.USER_PARAMS_SVC_USER},locale)))){
						msgReson=systemToolsService.getExpMessage(errorMessage.getErrorCode());
						return msgReson;
					}
					return LocaleMessageSourceResolver.getMessage(errorMessage.getErrorCode(),new Object[]{SystemConstrants.params.USER_PARAMS_SVC_USER},locale);
				default:
					return systemToolsService.getExpMessage(SystemExpConstants.common.USER_CODE_NOT_FOUND_ERROR);
				}
			} catch (Exception e) {
				return e.getMessage();
				
			}
		}
}
