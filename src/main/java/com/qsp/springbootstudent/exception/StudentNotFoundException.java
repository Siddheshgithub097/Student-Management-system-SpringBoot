package com.qsp.springbootstudent.exception;

public class StudentNotFoundException extends RuntimeException
{
	String message;
	
	@Override
	public String getMessage()
	{
		return message;
	}
	public StudentNotFoundException(String message)
	{
		super();
		this.message = message;
	}
}
