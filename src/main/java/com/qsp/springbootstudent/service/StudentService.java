package com.qsp.springbootstudent.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import com.qsp.springbootstudent.dao.StudentDao;
import com.qsp.springbootstudent.dto.Student;
import com.qsp.springbootstudent.util.ResourseStructure;

@Service
public class StudentService 
{
	@Autowired
	private StudentDao dao;
	
	ResourseStructure<Student> structure=new ResourseStructure<>();

	public ResponseEntity<ResourseStructure<Student>> saveStudent(Student student)
	{
		float securedMarks=student.getSecuredMarks();
		float totalMarks=student.getTotalMarks();
		double percentage=(securedMarks*100)/totalMarks;
		student.setPercentage(percentage);
		if (percentage<35)
		{
			student.setGrade("Fail");
		}
		else if (percentage>=35 && percentage<50)
		{
			student.setGrade("Pass");
		}
		else if (percentage>=50 && percentage<65)
		{
			student.setGrade("Second Class");
		}
		else if (percentage>=65 && percentage<90)
		{
			student.setGrade("First Class");
		}
		
		else if(percentage>=90 && percentage<=100)
		{
			student.setGrade("Distinction");
		}
		Student dbStudent=dao.saveStudent(student);
		structure.setMessage("Saved Succesfully");
		structure.setStatus(HttpStatus.CREATED.value());
		structure.setData(dbStudent);
		return new ResponseEntity<ResourseStructure<Student>>(structure,HttpStatus.CREATED);
	}

	public ResponseEntity<ResourseStructure<Student>> getStudent(int id)
	{
		Student student=dao.findStudentById(id);
		if (student!=null) 
		{
			structure.setMessage("Found Succesfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);
			return new ResponseEntity<ResourseStructure<Student>>(structure,HttpStatus.FOUND);
		}
		else
		{
			structure.setMessage("Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(student);
			return new ResponseEntity<ResourseStructure<Student>>(structure,HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResourseStructure<List<Student>>> getAllStudent() 
	{
		List<Student>list=dao.findAllStudent();
		ResourseStructure<List<Student>> structure=new ResourseStructure<List<Student>>();
		if (list.isEmpty())
		{
			structure.setMessage("Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResourseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
		}
		else
		{
			structure.setMessage("Found Succesfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResourseStructure<List<Student>>>(structure,HttpStatus.FOUND);
		}
	}

	public ResponseEntity<ResourseStructure<Student>> deleteStudent(int id) 
	{
		Student student=dao.deleteStudent(id);
		if(student!=null)
		{
			structure.setMessage("Delete Succesfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(student);
			return new ResponseEntity<ResourseStructure<Student>>(structure, HttpStatus.OK);
		}
		else 
		{
			structure.setMessage("Id Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(student);
			return new ResponseEntity<ResourseStructure<Student>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResourseStructure<Student>> updateStudent(int id, Student student)
	{
		Student dbStudent=dao.findStudentById(id);
		if (dbStudent!=null)
		{
			float securedMarks=student.getSecuredMarks();
			float totalMarks=student.getTotalMarks();
			double percentage=(securedMarks*100)/totalMarks;
			student.setPercentage(percentage);
			if (percentage<35)
			{
				student.setGrade("Fail");
			}
			else if (percentage>=35 && percentage<50)
			{
				student.setGrade("Pass");
			}
			else if (percentage>=50 && percentage<65)
			{
				student.setGrade("Second Class");
			}
			else if (percentage>=65 && percentage<90)
			{
				student.setGrade("First Class");
			}
			
			else if(percentage>=90 && percentage<=100)
			{
				student.setGrade("Distenction");
			}
			dao.updateStudent(id, student);
			structure.setMessage("Update Succesfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(dbStudent);
			return new ResponseEntity<ResourseStructure<Student>>(structure, HttpStatus.OK);
		}
		else
		{
			structure.setMessage("Id Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(dbStudent);
			return new ResponseEntity<ResourseStructure<Student>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResourseStructure<Student>> updateEmail(int id, String email)
	{
		Student student=dao.findStudentById(id);
		if (student!=null)
		{
			student.setEmail(email);
			dao.saveStudent(student);
			structure.setMessage("Update Succesfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(student);		
			return new ResponseEntity<ResourseStructure<Student>>(structure, HttpStatus.OK);
		}
		else
		{
			structure.setMessage("Id Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(student);
			return new ResponseEntity<ResourseStructure<Student>>(structure, HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<ResourseStructure<Student>> updatePhone(int id, long phone)
	{
		Student student=dao.findStudentById(id);
		if (student!=null)
		{
			student.setPhone(phone);
			dao.saveStudent(student);
			structure.setMessage("Update Succesfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(student);	
			return new ResponseEntity<ResourseStructure<Student>>(structure, HttpStatus.OK);
		}
		else
		{
			structure.setMessage("Id Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(student);
			return new ResponseEntity<ResourseStructure<Student>>(structure, HttpStatus.NOT_FOUND);
		}
	}

	public ResponseEntity<ResourseStructure<Student>> updateSecuredMarks(int id, int marks) 
	{
		Student student=dao.findStudentById(id);
		if (student!=null)
		{
			student.setSecuredMarks(marks);
			float totalMarks=student.getTotalMarks();
			double percentage=(marks*100)/totalMarks;
			student.setPercentage(percentage);
			if (percentage<35)
			{
				student.setGrade("Fail");
			}
			else if (percentage>=35 && percentage<50)
			{
				student.setGrade("Pass");
			}
			else if (percentage>=50 && percentage<65)
			{
				student.setGrade("Second Class");
			}
			else if (percentage>=65 && percentage<90)
			{
				student.setGrade("First Class");
			}
			
			else if(percentage>=90 && percentage<=100)
			{
				student.setGrade("Distenction");
			}
			dao.updateStudent(id, student);
			structure.setMessage("Update Succesfully");
			structure.setStatus(HttpStatus.OK.value());
			structure.setData(student);	
			return new ResponseEntity<ResourseStructure<Student>>(structure, HttpStatus.OK);
		}
		else
		{
			structure.setMessage("Id Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(student);
			return new ResponseEntity<ResourseStructure<Student>>(structure, HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<ResourseStructure<Student>> findByEmail(String email)
	{
		Student student=dao.findByEmail(email);
		if (student!=null)
		{
			structure.setMessage("Found Succesfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);
			return new ResponseEntity<ResourseStructure<Student>>(structure, HttpStatus.FOUND);
		}
		else
		{
			structure.setMessage("Email Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(student);
			return new ResponseEntity<ResourseStructure<Student>>(structure, HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<ResourseStructure<Student>> findByPhone(long phone)
	{
		Student student=dao.findByPhone(phone);
		if (student!=null)
		{
			structure.setMessage("Found Succesfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(student);
			return new ResponseEntity<ResourseStructure<Student>>(structure, HttpStatus.FOUND);
		}
		else
		{
			structure.setMessage("Email Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(student);
			return new ResponseEntity<ResourseStructure<Student>>(structure, HttpStatus.NOT_FOUND);
		}
	}
	public ResponseEntity<ResourseStructure<List<Student>>> findStudentsBySecuredMarkes(int seucredMarks)
	{
		List<Student>list=dao.findStudentsBySecuredMarks(seucredMarks);
		ResourseStructure<List<Student>>structure=new ResourseStructure<>();
		if (list.isEmpty())
		{
			structure.setMessage("Found Successfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResourseStructure<List<Student>>>(structure,HttpStatus.FOUND);
		}
		else
		{
			structure.setMessage("Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResourseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
		}
	}	
	public ResponseEntity<ResourseStructure<List<Student>>> findbySecuredMarkListLessThan(int securedMarks)
	{
		List<Student>list=dao.findbySecuredMarkListLessThan(securedMarks);
		ResourseStructure<List<Student>>structure=new ResourseStructure<>();
		if (list.isEmpty())
		{
			structure.setMessage("Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResourseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND);
		}
		else
		{
			structure.setMessage("Found Succesfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResourseStructure<List<Student>>>(structure,HttpStatus.FOUND);
		}
	}
	public ResponseEntity<ResourseStructure<List<Student>>> greaterThan(double percentage)
	{
		List<Student>list=dao.greaterThan(percentage);
		ResourseStructure<List<Student>>structure=new ResourseStructure<>();
		if (list.isEmpty())
		{
			structure.setMessage("Not Found");
			structure.setStatus(HttpStatus.NOT_FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResourseStructure<List<Student>>>(structure,HttpStatus.NOT_FOUND); 
		}
		else
		{
			structure.setMessage("Found Succesfully");
			structure.setStatus(HttpStatus.FOUND.value());
			structure.setData(list);
			return new ResponseEntity<ResourseStructure<List<Student>>>(structure,HttpStatus.FOUND); 
		}	
	}
}
