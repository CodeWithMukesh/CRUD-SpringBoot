package com.mukesh.crud.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import com.mukesh.crud.model.Student;
import com.mukesh.crud.service.StudentService;

@Controller
public class StudentController {

	@Autowired
	private StudentService studentService;

	/* Display all student records on home page */
	@GetMapping("/")
	public String viewHomepage(Model model) {
		/* fetching records from database */
		Model student = model.addAttribute("student", studentService.getAllStudents());
		System.out.println(student);
		return "index";
	}

	/*
	 * when you click on 'add-new-student' at the index page it will be redirected
	 * to the add_student page where will get a form and you can take a new student
	 * data in this form
	 */
	@GetMapping("/addNewStudent")
	public String addNewStudent(Model model) {
		Student student = new Student();
		model.addAttribute("student", student);
		return "add_student";
	}

	/*
	 * after submitted the add_student form we have to retrieve all submitted data
	 * and save into the database
	 */
	@PostMapping("/saveStudent")
	public String saveStudent(@ModelAttribute("student") Student student) {
		// save to database
		studentService.insertStudent(student);
		return "redirect:/";
	}

	/* Update Student of with the help of selected id */
	@GetMapping("/updateStudent/{id}")
	public String updateStudent(@PathVariable(value = "id") int id, Model model) {
		// call to service to get a update method
		Student studentById = studentService.getStudentById(id);
		model.addAttribute("student", studentById);
		return "update_student";
	}

	/* Delete student of the selected id */
	@GetMapping("/deleteStudent/{id}")
	public String deleteStudent(@PathVariable(value = "id") int id, Model model) {
		studentService.deleteStudentById(id);
		return "redirect:/";
	}

}