package com.kimdeath.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.cloud.context.config.annotation.RefreshScope;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * 自动刷新配置文件
 * @RefreshScope 标注的bean会特殊被刷新处理
 * 修改git 仓库文件信息
 * 采用Curl 命令 curl -X POST http://当前应用服务器IP值/refresh
 * 需要哪个bean访问当前服务接口就可以
 * PS:使用该注解需要用到 
 *
 */
@RestController
@RefreshScope //手动刷新注解 
public class PropertiesController {

	@Value("${profiles}")
	private String target;
	
	@GetMapping("/getTarget")
	public String getTarger(){
		return this.target;
	}
}
