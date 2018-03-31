package com.example.rest.springrestws.hello;

import java.util.Locale;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.MessageSource;
import org.springframework.context.i18n.LocaleContext;
import org.springframework.context.i18n.LocaleContextHolder;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

//Controller
@RestController
public class HelloWorldController {

	@Autowired
	private MessageSource messageSource;
	// Get
	// URI
	// Method
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world")
	public String helloWorld() {

		return "HelloWorld";
	}
	
	// Example return Bean
	@RequestMapping(method = RequestMethod.GET, path = "/hello-world-Bean")
	public HelloWorldBean helloWorldBean() {

		return new HelloWorldBean("HelloWorld");
	}
	
	// Example Path variable
		@RequestMapping(method = RequestMethod.GET, path = "/hello-world-Bean/path/{name}")
		public HelloWorldBean helloWorldBeanPath(@PathVariable String name) {

			return new HelloWorldBean(String.format("HelloWorld, %s ",name));
		}
	
		//method for I18N
		@RequestMapping(method = RequestMethod.GET, path = "/hello-world-i18n")
		public String helloWorldInternationalisation(@RequestHeader(name="Accept-Language",required =false) Locale locale) {

			return messageSource.getMessage("good.morning.message",null, locale);
		}
		
		//method for I18N
				@RequestMapping(method = RequestMethod.GET, path = "/hello-world-i18n2")
				public String helloWorldInternationalisationpart2() {

					return messageSource.getMessage("good.morning.message",null, LocaleContextHolder.getLocale());
				}
	
}
