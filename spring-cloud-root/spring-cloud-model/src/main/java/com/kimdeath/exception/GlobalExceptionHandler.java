package com.kimdeath.exception;

import java.util.Date;
import java.util.Locale;

import javax.servlet.http.HttpServletRequest;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import com.isoftstone.cityinsight.entity.bo.ErrorMessageInfoBO;
import com.isoftstone.cityinsight.entity.dto.AbstractResultDTO;
import com.isoftstone.cityinsight.exception.AbstractException;
import com.isoftstone.cityinsight.utils.CommonTools;
import com.kimdeath.constrants.SystemConstrants;
import com.kimdeath.constrants.SystemExpConstants;
import com.kimdeath.service.SystemToolsService;


/**
 * 统一异常翻译处理 
 * @author chenjl
 * @since 2017-2-9
 * @version 1.0
 * 
 */
@ControllerAdvice
public class GlobalExceptionHandler {
	
	private final static Log logger=LogFactory.getLog(GlobalExceptionHandler.class);
	
	@Autowired
	private LocaleMessageSourceResolver LocaleMessageSourceResolver; //国际化解析器 todo
	
	@Autowired
	private  SystemToolsService systemToolsService;

    @Value("${msg.sys_props_switch}")
    private String sys_props_switch;
	
	//指定处理异常机制
	@ExceptionHandler(value=AbstractException.class)
	@ResponseBody
	public AbstractResultDTO jsonHandler(HttpServletRequest req, AbstractException ae) throws Exception
	{
		Locale locale = LocaleContextHolder.getLocale();//获取区域信息
		logger.info("Context DataMap:{ ErrorKey:"+ae.getMessageKey()+",ErrorArg:"+ae.getArgs()+",locale:"+locale);
		String switchFlag=sys_props_switch;
		ErrorMessageInfoBO errorMessage=new ErrorMessageInfoBO();
		AbstractResultDTO<String> errorMessageResult=new AbstractResultDTO<String>();
//		errorMessage.setErrorCode(SystemExpConstants.common.USER_DATA_MODEL_SYSTEM_ERROR);
		errorMessage.setErrorCode(ae.getMessageKey());
		errorMessage.setErrorReason(HandleErrorCode(errorMessage,switchFlag,ae,locale));	
		errorMessage.setErrorData(ae.getStackMessage());
		logger.info("");
		errorMessage.setCreateTime(new Date());
		errorMessageResult.setExpFlag((SystemConstrants.returnCode.USER_RETURNCODE_Y));
		errorMessageResult.setErrorMessageInfoBO(errorMessage);
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
	private String HandleErrorCode(ErrorMessageInfoBO errorMessage ,String code,AbstractException ae,Locale locale){
		try {
			switch (code) {
			case "1":
				 //读取参数以本地参数文件为准*.properties
				return LocaleMessageSourceResolver.getMessage(errorMessage.getErrorCode(),ae.getArgs(),locale);
			case "2":
				//获取参数以数据库参数为准  
				return systemToolsService.getExpMessage(errorMessage.getErrorCode());
			case "3":
				// 获取先根据本地参数文件然后根据数据库
				String msgReson="";
				if((CommonTools.isNullOrEmpty(LocaleMessageSourceResolver.getMessage(errorMessage.getErrorCode(),ae.getArgs(),locale)))){
					msgReson=systemToolsService.getExpMessage(errorMessage.getErrorCode());
					return msgReson;
				}
				return LocaleMessageSourceResolver.getMessage(errorMessage.getErrorCode(),ae.getArgs(),locale);
			default:
				return systemToolsService.getExpMessage(SystemExpConstants.common.USER_CODE_NOT_FOUND_ERROR);
			}
		} catch (Exception e) {
			return e.getMessage();
			
		}
	}
}
