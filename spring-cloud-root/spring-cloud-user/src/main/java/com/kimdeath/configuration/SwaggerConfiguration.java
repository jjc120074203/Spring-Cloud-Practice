package com.kimdeath.configuration;


import static springfox.documentation.builders.PathSelectors.regex;

import java.util.Arrays;
import java.util.HashSet;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.http.MediaType;

import com.google.common.base.Predicate;

import springfox.documentation.annotations.ApiIgnore;
import springfox.documentation.builders.ApiInfoBuilder;
import springfox.documentation.builders.ParameterBuilder;
import springfox.documentation.schema.ModelRef;
import springfox.documentation.service.*;
import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

/**
 * Created by jiazaibo on 17-3-1.
 */
@Configuration
@EnableSwagger2
@ComponentScan(basePackages = {"com.kimdeath.controller"})
public class SwaggerConfiguration {

	private SecurityScheme cableServiceAuthToken() {
		return new ApiKey("Spring-Cloud-Auth-Token", "Spring-Cloud-Auth-Token", "header");
	}

	   
    private HashSet<String> produecetypes(){
        HashSet <String> hs = new HashSet<String>();
        hs.add(MediaType.APPLICATION_JSON_VALUE);
        return hs;
    }
	
    /**
     * 不需要权限认证的api
     */
    @Bean
    public Docket generalPubApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .produces(produecetypes())
                .groupName("general-pub-api")
                .apiInfo(pubApiInfo())
                .select()
                .paths(pubPaths())
                .build()
                .ignoredParameterTypes(ApiIgnore.class)
                .enableUrlTemplating(false);
    }
    
    private ApiInfo pubApiInfo() {
    	Contact contact = new Contact("husong", "", "");
        return new ApiInfoBuilder()
                .title("pub Description API")
                .description("Swagger API")
                .contact(contact)
                .version("2.0")
                .build();
    }
    
    private Predicate<String> pubPaths() {
        return regex("/pub/.*");
    }
    
    /**
     *需要权限认证的api
     */
    @Bean
    public Docket generalAppApi() {
        return new Docket(DocumentationType.SWAGGER_2)
                .produces(produecetypes())
                .groupName("general-app-api")
                .apiInfo(appApiInfo())
                .select()
                .paths(appPubPaths())
                .build()
                .securitySchemes(Arrays.asList(cableServiceAuthToken()))
                .ignoredParameterTypes(ApiIgnore.class)
                .enableUrlTemplating(false);
    }
    
    private ApiInfo appApiInfo() {
    	Contact contact = new Contact("chenjl", "", "");
        return new ApiInfoBuilder()
                .title("pub Description API")
                .description("Swagger API")
                .contact(contact)
                .version("2.0")
                .build();
    }
    
    private Predicate<String> appPubPaths() {
        return regex("/app/.*");
    }
   
    
}
