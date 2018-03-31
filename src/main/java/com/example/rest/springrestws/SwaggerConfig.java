package com.example.rest.springrestws;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import springfox.documentation.spi.DocumentationType;
import springfox.documentation.spring.web.plugins.Docket;
import springfox.documentation.swagger2.annotations.EnableSwagger2;

//configuration
//Enable Swagger
@Configuration
@EnableSwagger2
public class SwaggerConfig {

	//Bean Docklet
	@Bean
	public Docket api()
	{
		return new Docket(DocumentationType.SWAGGER_2);
		
	}
	//Swagger 2
	//all the path
	//all the apis
	
}
