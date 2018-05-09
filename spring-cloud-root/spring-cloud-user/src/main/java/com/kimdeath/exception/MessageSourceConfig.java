package com.kimdeath.exception;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.support.ReloadableResourceBundleMessageSource;

import com.kimdeath.constrants.SystemExpConstants;



/**
 * 
 * 国际化配置
 * 
 * @author chenjl
 * @since 2017-2-14
 * @version 1.0
 *
 */
@Configuration
public class MessageSourceConfig {
	
	 @Value("${messagesource.basename}")
	 private String basename;
	 @Value("${messagesource.encoding}")
	 private String Encoding;
	 @Value("${messagesource.cache-seconds}")
	 private int cacheSeconds;
	 
	@Bean(name="messageSource")
	public ReloadableResourceBundleMessageSource messageSource(){  
		ReloadableResourceBundleMessageSource messageSource=new ReloadableResourceBundleMessageSource();  
		messageSource.setBasename(basename);  
		messageSource.setUseCodeAsDefaultMessage(true); 
		messageSource.setDefaultEncoding(Encoding);
		messageSource.setCacheSeconds(cacheSeconds);
		messageSource.getMessage(SystemExpConstants.common.USER_CODE_NOT_FOUND_ERROR, new Object[]{}, null, null); //激活翻译代码，同步路径  fix me 
		return messageSource;  
   }
}
