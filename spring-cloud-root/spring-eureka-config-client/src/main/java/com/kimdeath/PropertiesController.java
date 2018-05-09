package com.kimdeath;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PropertiesController {

	@Value("${profile}")
	private String target;
	
	@GetMapping("/getTarget")
	public String getTarger(){
		return this.target;
	}
}
