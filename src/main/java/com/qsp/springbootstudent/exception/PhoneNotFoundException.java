package com.qsp.springbootstudent.exception;

public class PhoneNotFoundException extends RuntimeException
{
	String message;
	
	@Override
	public String getMessage() 
	{
		return message;
	}

	public PhoneNotFoundException(String message) 
	{
		super();
		this.message = message;
	}
}
