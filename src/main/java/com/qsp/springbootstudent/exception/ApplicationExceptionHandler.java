package com.qsp.springbootstudent.exception;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

import com.qsp.springbootstudent.util.ResourseStructure;

@RestControllerAdvice
public class ApplicationExceptionHandler
{
	@ExceptionHandler(IdNotFoundException.class)
	public ResponseEntity<ResourseStructure<String>> idNotFoundExceptionHandler(IdNotFoundException exception)
	{
		ResourseStructure<String>structure=new ResourseStructure<>();
		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Student With Given Id Not Found");
		
		return new ResponseEntity<ResourseStructure<String>>(structure, HttpStatus.BAD_REQUEST);
	}
	@ExceptionHandler(EmailNotFoundException.class)
	public ResponseEntity<ResourseStructure<String>> emailNotFoundExceptionException(EmailNotFoundException exception)
	{
		ResourseStructure<String>structure=new ResourseStructure<>();
		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Student With Given Email Not Found");
		
		return new ResponseEntity<ResourseStructure<String>>(structure, HttpStatus.BAD_REQUEST);	
	}
	@ExceptionHandler(PhoneNotFoundException.class)
	public ResponseEntity<ResourseStructure<String>> phoneNotFoundExceptionHandler(PhoneNotFoundException exception)
	{
		ResourseStructure<String>structure=new ResourseStructure<>();
		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Student With Given Phone Number Not Found");
		
		return new ResponseEntity<ResourseStructure<String>>(structure, HttpStatus.BAD_REQUEST);	
	}
	@ExceptionHandler(StudentNotFoundException.class)
	public ResponseEntity<ResourseStructure<String>> noStudentFoundExceptionHandler(StudentNotFoundException exception)
	{
		ResourseStructure<String>structure=new ResourseStructure<>();
		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Students Not Found");
		
		return new ResponseEntity<ResourseStructure<String>>(structure, HttpStatus.BAD_REQUEST);	
	}
	@ExceptionHandler(GivenRangeOfMarksException.class)
	public ResponseEntity<ResourseStructure<String>> noStudentWithinRangeExceptionHandler(GivenRangeOfMarksException exception)
	{
		ResourseStructure<String>structure=new ResourseStructure<>();
		structure.setMessage(exception.getMessage());
		structure.setStatus(HttpStatus.BAD_REQUEST.value());
		structure.setData("Students Within range are not found");
		
		return new ResponseEntity<ResourseStructure<String>>(structure, HttpStatus.BAD_REQUEST);	
	}
	
}
