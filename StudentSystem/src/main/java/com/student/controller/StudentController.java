package com.student.controller;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.student.model.Student;
import com.student.service.StudentService;

@RestController
public class StudentController {

	private StudentService studentService;

	public StudentController(StudentService studentService) {
		super();
		this.studentService = studentService;
	}
	
	// Create Student
	@PostMapping("student/create")
	ResponseEntity<Student> createStudent(@RequestBody Student student){
		return new ResponseEntity<Student>(studentService.saveStudent(student), HttpStatus.CREATED);
		
	}
	
	// Get All List
	@GetMapping("student/showall")
	List<Student> showall(){
		return studentService.getAllStudents();
	}
	
	// Find student by Id
	@GetMapping("student/findbyid/{id}")
	ResponseEntity<Student> findStudent(@PathVariable("id") long id){
		return new ResponseEntity<Student>(studentService.showbyID(id), HttpStatus.OK);
		
	}
	
	// Update student
	@PutMapping("student/update/{id}")
	ResponseEntity<Student> updateStud(@RequestBody Student student , @PathVariable("id") long id){
		return new ResponseEntity<Student>(studentService.updateStudent(student, id), HttpStatus.OK);
	}
	
	// Delete student
	@DeleteMapping("student/delete/{id}")
	public ResponseEntity<String> deleteStudent(@PathVariable("id") long id){
		studentService.deleteStudent(id);
		return new ResponseEntity<String>("Student Deleted Successfully", HttpStatus.OK);
	}
	
}
