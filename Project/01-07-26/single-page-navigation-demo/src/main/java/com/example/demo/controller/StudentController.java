package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class StudentController {

	@GetMapping("/student")
	public String student(Model model) {

	    model.addAttribute("title", "Student Details");

	    model.addAttribute("name", "Brijesh");
	    model.addAttribute("email", "brijesh@gmail.com");
	    model.addAttribute("semester", "6th");
	    model.addAttribute("college", "Lovely Professional University");

	    model.addAttribute("image", "https://i.pinimg.com/736x/50/fa/0a/50fa0ac8333be4687c4fa27691f6bdd3.jpg");

	    return "dashboard";
	}
}