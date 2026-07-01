package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ContactController {
	@GetMapping("/contact")
	public String contact(Model model) {

	    model.addAttribute("title", "Contact");
	    model.addAttribute("message",
	            "Email us at school@gmail.com");

	    model.addAttribute("image", "https://i.pinimg.com/1200x/a6/83/e9/a683e9dd28c495ab982b5cc2e9b60856.jpg");

	    return "dashboard";
	}
}
