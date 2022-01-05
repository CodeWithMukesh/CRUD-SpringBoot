package com.mukesh.crud.service;

import java.util.List;
import com.mukesh.crud.model.Student;

public interface StudentService {
	
	//getting student from database
	public List<Student> getAllStudents(); 
	
	//inserting data into database
	public void insertStudent(Student student);
	
	//update student record using id
	public Student getStudentById(int id);
	
	//delete student record using id
	public void deleteStudentById(int id);
	
}