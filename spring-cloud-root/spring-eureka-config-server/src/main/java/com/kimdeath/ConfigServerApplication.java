package com.kimdeath;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.config.server.EnableConfigServer;

@SpringBootApplication
@EnableConfigServer
public class ConfigServerApplication{
	 public static void main(String [] args) {
		  SpringApplication.run(ConfigServerApplication.class, args);
	    }
}

/*
 *  访问内容:http://localhost:7070/abasdadc-default1.properties
 * 
 * /{application}/{profile}[/{label}]
 * /{application}-{profile}.yml
 * /{label}/{application}-{profile}.yml  
 * /{application}-{profile}.properties
 * /{label}/{application}-{profile}.properties
 * 
 *  application  任意写 默认一个话 ，如果又两个文件
 *  label  表示分支
 *  http://localhost:7070/develop/abasdadc-default1.properties
 *  http://localhost:7070/master/abasdadc-default1.properties
 *  
 * */

