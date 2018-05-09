package com.kimdeath;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.builder.SpringApplicationBuilder;
import org.springframework.cloud.netflix.eureka.EnableEurekaClient;


@SpringBootApplication
@EnableEurekaClient//服务注解
public class ModelApplication {

    public static void main(String [] args) {
        new SpringApplicationBuilder(ModelApplication.class).web(true).run(args);
    }

}
