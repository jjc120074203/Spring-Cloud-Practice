package com.kimdeath.exception;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.NoSuchMessageException;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.stereotype.Component;

import com.kimdeath.constrants.SystemExpConstants;


/**
 * 
 * 国际化i8n
 * @author chenjl
 * @since 2017年2月9日
 * @version 1.0
 *
 */
@Component
public class LocaleMessageSourceResolver  {
	
	@Autowired
    private  MessageSource messageSource;
	
	/**
     * @param code ：对应messages配置的key.
     * @return
     */
    public String getMessage(String code){
    	String msg="";
    	try {
			 msg=messageSource.getMessage(code,new Object[]{},null);
		} catch (NoSuchMessageException e) {
			msg=messageSource.getMessage(SystemExpConstants.common.USER_CODE_NOT_FOUND_ERROR,new Object[]{},null);;
		}
    	
       return msg;
    }
    
    /**
     * 获取错误信息
     * @param code ：对应messages配置的key.
     * @param args : 数组参数.
     * @return
     */
    public String getMessage(String code,Object[] args){
      	String msg="";
    	try {
			 msg=messageSource.getMessage(code,args,null);
		} catch (NoSuchMessageException e) {
			msg=messageSource.getMessage(SystemExpConstants.common.USER_CODE_NOT_FOUND_ERROR,args,null);;
		}
       return msg;
    }

    public String getMessage(String code,Object[] args,Locale locale){
    	String msg="";
    	try {
			 msg=messageSource.getMessage(code,args,locale);
		} catch (NoSuchMessageException e) {
			msg=messageSource.getMessage(SystemExpConstants.common.USER_CODE_NOT_FOUND_ERROR,args,locale);;
		}
       return msg;
    }

    /**
     *
     * @param code ：对应messages配置的key.
     * @param args : 数组参数.
     * @param defaultMessage : 没有设置key的时候的默认值.
     * @return
     */
    public String getMessage(String code,Object[] args,String defaultMessage){
       //这里使用比较方便的方法，不依赖request.
       Locale locale =LocaleContextHolder.getLocale();
       return getMessage(code, args, defaultMessage, locale);
    }

    /**
     * 指定语言.
     * @param code 错误码
     * @param args 默认错误
     * @param defaultMessage 默认错误信息
     * @param locale 本地国际化
     * @return
     */
    public String getMessage(String code,Object[]args,String defaultMessage,Locale locale){
       return messageSource.getMessage(code, args, defaultMessage,locale);
    }

}
