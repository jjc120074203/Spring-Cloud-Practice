package com.kimdeath;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.server.EnableEurekaServer;

@SpringBootApplication
@EnableEurekaServer
public class RegisterTestHA{
	 public static void main(String [] args) {
	        new SpringApplicationBuilder(RegisterTestHA.class).web(true).run(args);
	    }
}