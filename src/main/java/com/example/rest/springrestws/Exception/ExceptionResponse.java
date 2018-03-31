package com.example.rest.springrestws.Exception;

import java.util.Date;

public class ExceptionResponse {
   
	private Date timestamp;
	
	private String msg;
	
	private String description;

	public ExceptionResponse(Date timestamp, String msg, String description) {
		super();
		this.timestamp = timestamp;
		this.msg = msg;
		this.description = description;
	}

	
	public ExceptionResponse(Date timestamp, String msg) {
		super();
		this.timestamp = timestamp;
		this.msg = msg;
	}


	public Date getTimestamp() {
		return timestamp;
	}

	public void setTimestamp(Date timestamp) {
		this.timestamp = timestamp;
	}

	public String getMsg() {
		return msg;
	}

	public void setMsg(String msg) {
		this.msg = msg;
	}

	public String getDescription() {
		return description;
	}

	public void setDescription(String description) {
		this.description = description;
	}
	
	
}
