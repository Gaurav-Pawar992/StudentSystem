package com.student.service;

import java.util.List;

import com.student.model.Student;

public interface StudentService {
	
	Student saveStudent(Student student);
	
	List<Student> getAllStudents();

	Student showbyID (long id);
	
	Student updateStudent(Student student , long id);
	
	void deleteStudent(long id);
}
