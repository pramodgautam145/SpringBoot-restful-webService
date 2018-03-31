package com.example.rest.springrestws;

import java.util.Locale;

import org.springframework.boot.Banner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.web.servlet.WebMvcProperties.LocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.context.support.ResourceBundleMessageSource;
import org.springframework.web.server.i18n.AcceptHeaderLocaleContextResolver;
import org.springframework.web.servlet.i18n.AcceptHeaderLocaleResolver;
import org.springframework.web.servlet.i18n.SessionLocaleResolver;

@SpringBootApplication
public class SpringRestWsApplication {

	public static void main(String[] args) {
		// 1st syntex to run 
		//SpringApplication.run(SpringRestWsApplication.class, args);
		//Spring boot logo off
		//2nd Approach
		 SpringApplication app = new SpringApplication(SpringRestWsApplication.class);
	        app.setBannerMode(Banner.Mode.OFF);
	        app.run(args);
	}
	
	//used for I18N
	@Bean
	public org.springframework.web.servlet.LocaleResolver  localeResolver()
	{
		//SessionLocaleResolver localeResolver =new  SessionLocaleResolver();
		//this used when we want not put accept-language parameter controller method
		AcceptHeaderLocaleResolver localeResolver =new  AcceptHeaderLocaleResolver();
		localeResolver.setDefaultLocale(Locale.US);
		return localeResolver;
		
	}
	
	/*//should care name of method should be messageSource 
	 * when configure application.properties spring.messages.basename=messages 
	 * we comment this method
	@Bean
	public ResourceBundleMessageSource messageSource()
	{
		ResourceBundleMessageSource messageSource =new ResourceBundleMessageSource();
		messageSource.setBasename("message");
		return messageSource;
		
	}*/
}
