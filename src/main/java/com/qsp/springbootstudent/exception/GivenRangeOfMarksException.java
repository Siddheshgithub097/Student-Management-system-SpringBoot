package com.qsp.springbootstudent.exception;

public class GivenRangeOfMarksException extends RuntimeException
{
String message;
	
	@Override
	public String getMessage() 
	{
		return message;
	}
	public GivenRangeOfMarksException(String message) 
	{
		super();
		this.message = message;
	}
}
