package com.kimdeath;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.turbine.EnableTurbine;

/**
 * @author issuser
 * http://localhost:5000/turbine.stream?cluster=SPRING-CLOUD-PORTAL
 */
@EnableTurbine
@SpringBootApplication
public class TurbineApplication {
	public static void main(String[] args) {
		new SpringApplicationBuilder(TurbineApplication.class).web(true).run(args);
	}
}
