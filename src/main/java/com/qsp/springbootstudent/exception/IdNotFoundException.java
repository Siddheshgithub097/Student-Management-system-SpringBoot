package com.qsp.springbootstudent.exception;

public class IdNotFoundException extends RuntimeException
{
String message;
	
	public String getMessage()
	{
		return message;
	}

	public IdNotFoundException(String message) {
		super();
		this.message = message;
	}
}
