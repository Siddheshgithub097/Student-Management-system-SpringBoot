package com.qsp.springbootstudent.dao;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.qsp.springbootstudent.dto.Student;
import com.qsp.springbootstudent.repo.StudentRepo;

@Repository
public class StudentDao 
{
	@Autowired
	private StudentRepo repo;
	
	public Student saveStudent(Student student)
	{
		return repo.save(student);
	}
	public Student findStudentById(int id)
	{
		Optional<Student> optional=repo.findById(id);
		if (optional.isPresent())
		{
			return optional.get();
		}
		return null;
	}
	public List<Student> findAllStudent()
	{
		return repo.findAll();
	}
	public Student deleteStudent(int id)
	{
		Optional<Student> optional=repo.findById(id);
		if (optional.isPresent()) 
		{
			Student student=optional.get();
			repo.deleteById(id);
			return student;
		}
		return null;
	}
	public Student updateStudent(int id,Student student)
	{
		Optional<Student> optional=repo.findById(id);
		if (optional.isEmpty())
		{
			return null;
		}
		student.setId(id);
		return repo.save(student);
	}
	public Student findByEmail(String email)
	{
		return repo.findStudentByEmail(email);
	}
	
	public Student findByPhone(long phone)
	{
		return repo.findStudentByPhone(phone);
	}
	public List<Student> findStudentsBySecuredMarks(int securedMarks)
	{
		return repo.findStudentBySecuredMarksGreaterThan(securedMarks);
	}
	
	public List<Student> findbySecuredMarkListLessThan(int securedMarks)
	{
		return repo.findbySecuredMarkListLessThan(securedMarks);
	} 
	public List<Student> greaterThan(double percentage)
	{
		return repo.greaterThan(percentage);
	}

}
