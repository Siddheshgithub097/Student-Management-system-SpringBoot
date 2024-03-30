package com.qsp.springbootstudent.repo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

import com.qsp.springbootstudent.dto.Student;

public interface StudentRepo extends JpaRepository<Student,Integer>
{
	Student findStudentByEmail(String email);
	@Query("SELECT e FROM Student e WHERE e.phone=?1")
	Student findStudentByPhone(long phone);
	
	List<Student> findStudentBySecuredMarksGreaterThan(int marks);
	@Query("SELECT s FROM Student s WHERE s.securedMarks<=?1")
	List<Student> findbySecuredMarkListLessThan(int marks);
	@Query("SELECT S FROM Student S WHERE S.percentage>=?1 ")
	List<Student> greaterThan(double percentage);
}

