package com.example.rest.springrestws.Exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;
//used for exception set status code for during excption
@ResponseStatus(HttpStatus.NOT_FOUND)
public class UserNotFound extends RuntimeException {

	public UserNotFound(String arg0) {
		super(arg0);
		
	}

	
}
