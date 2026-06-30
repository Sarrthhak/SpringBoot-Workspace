package com.example.demo;

import java.util.ArrayList;
import java.util.List;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class StudentController {
	private List<Student> students=new ArrayList<>();
	public StudentController() {
		students.add(new Student(1,"Sarthak")); 
		students.add(new Student(2,"Sahil")); 
		// TODOs Auto-generated constructor stub
	}
	@GetMapping("/student/{id}")
	public Student getStudentByid(@PathVariable int id) {
		for(Student s : students) {
			if(s.getId()==id) {
				return s;
			}
		}
		throw new StudentNotFoundException("Student not found with id "+id);
	}
	
}
