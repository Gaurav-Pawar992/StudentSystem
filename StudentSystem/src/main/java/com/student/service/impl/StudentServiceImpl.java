package com.student.service.impl;

import java.util.List;

import org.springframework.stereotype.Service;

import com.student.exception.ResourceNotFoundException;
import com.student.model.Student;
import com.student.repository.StudentRepository;
import com.student.service.StudentService;

@Service
public class StudentServiceImpl implements StudentService {
	
	private StudentRepository studentRepository;

	public StudentServiceImpl(StudentRepository studentRepository) {
		super();
		this.studentRepository = studentRepository;
	}

	@Override
	public Student saveStudent(Student student) {
		// TODO Auto-generated method stub
		return studentRepository.save(student);
	}

	@Override
	public List<Student> getAllStudents() {
		// TODO Auto-generated method stub
		return studentRepository.findAll();
	}

	@Override
	public Student showbyID(long id) {
		// TODO Auto-generated method stub
		return studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student", "Id", id));
	}

	@Override
	public Student updateStudent(Student student, long id) {
		// TODO Auto-generated method stub
		
		Student existStudent = studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student", "Id", id));
		
		existStudent.setFirstName(student.getFirstName());
		existStudent.setLastName(student.getLastName());
		
		studentRepository.save(existStudent);
		
		return existStudent;
	}

	@Override
	public void deleteStudent(long id) {
		// TODO Auto-generated method stub
		
		studentRepository.findById(id).orElseThrow(()->new ResourceNotFoundException("Student", "Id", id));
		
		studentRepository.deleteById(id);;
		
		
	}
	
	

}
