package com.mukesh.crud.service;

import java.util.List;
import java.util.Optional;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import com.mukesh.crud.model.Student;
import com.mukesh.crud.repository.StudentRepository;

@Service
public class StudentServiceImp implements StudentService {

	@Autowired
	private StudentRepository studentRepository;
	
	@Override
	public List<Student> getAllStudents() {		
		return studentRepository.findAll();
	}

	@Override
	public void insertStudent(Student student) {
		this.studentRepository.save(student);		
	}

	@Override
	public Student getStudentById(int id) {
		Optional<Student> optional = studentRepository.findById(id);
		Student student = null;
		if(optional.isPresent()) {
		 student = optional.get();
		}
		else {
			throw new RuntimeException("Student not found for this id :"+id);
		}
		return student;		
	}

	@Override
	public void deleteStudentById(int id) {
		studentRepository.deleteById(id);
	}
	
}