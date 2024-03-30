package com.qsp.springbootstudent.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PatchMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.qsp.springbootstudent.dto.Student;
import com.qsp.springbootstudent.service.StudentService;
import com.qsp.springbootstudent.util.ResourseStructure;

@RestController
public class StudentController 
{
	@Autowired
	private StudentService service;
	
	@PostMapping("/saveStudent")
	public ResponseEntity<ResourseStructure<Student>> saveStudent(@RequestBody Student student)
	{
		return service.saveStudent(student);
	}
	@GetMapping("/findStudent")
	public ResponseEntity<ResourseStructure<Student>> findStudentById(@RequestParam int id)
	{
		return service.getStudent(id);
	}
	@GetMapping("/fetchStudent")
	public ResponseEntity<ResourseStructure<List<Student>>> findAllStudent()
	{
		return service.getAllStudent();
	}
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<ResourseStructure<Student>> deleteStudent(@PathVariable int id)
	{
		return service.deleteStudent(id);
	}
	@PutMapping("/updateStudent")
	public ResponseEntity<ResourseStructure<Student>> updateStudent(@RequestParam int id,@RequestBody Student student)
	{
		return service.updateStudent(id,student);
	}
	@PatchMapping("/updateEmail/{id}")
	public ResponseEntity<ResourseStructure<Student>> updateEmail(@PathVariable int id,@RequestParam String email)
	{
		return service.updateEmail(id,email);
	}
	@PatchMapping("/updatePhone/{id}")
	public ResponseEntity<ResourseStructure<Student>> updatePhone(@PathVariable int id,@RequestParam long phone)
	{
		return service.updatePhone(id, phone);
	}
	@PatchMapping("/updateSecuredMarks/{id}")
	public ResponseEntity<ResourseStructure<Student>> updateSecuredMarks(@PathVariable int id,@RequestParam int securedMarks)
	{
		return service.updateSecuredMarks(id,securedMarks);
	}
	@GetMapping("/findByEmail")
	public ResponseEntity<ResourseStructure<Student>> findByEmail(@RequestParam String email) 
	{
		return service.findByEmail(email); 
	}
	@GetMapping("/findByPhone/{phone}")
	public ResponseEntity<ResourseStructure<Student>> findByPhone(@PathVariable long phone)
	{
		return service.findByPhone(phone);
	}
	@GetMapping("/findStudentsBySecuredMarks/{securedMarks}")
	public ResponseEntity<ResourseStructure<List<Student>>> findStudentsBySecuredMarks(@PathVariable int securedMarks)
	{
		return service.findStudentsBySecuredMarkes(securedMarks); 
	}
	@GetMapping("/findbySecuredMarkListLessThan")
	public ResponseEntity<ResourseStructure<List<Student>>> findbySecuredMarkListLessThan(@RequestParam int securedMarks)
	{
		return service.findbySecuredMarkListLessThan(securedMarks);
	}
}
