package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class HomeController {
	@GetMapping("/")
	public String home(Model model) {

	    model.addAttribute("title", "Home");
	    model.addAttribute("message", "Welcome to the Portal Home Page");

	    model.addAttribute("image", "https://i.pinimg.com/736x/94/29/76/942976f5a1d91cbf8e51ab970044b1ae.jpg");

	    return "dashboard";
	}
}
