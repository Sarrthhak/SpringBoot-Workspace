package com.example.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class AboutController {
	@GetMapping("/about")
	public String about(Model model) {

	    model.addAttribute("title", "About");
	    model.addAttribute("message",
	            "This school was established in 1990.");

	    model.addAttribute("image", "https://i.pinimg.com/736x/e9/eb/9e/e9eb9ec1b0da71003807507b2368cd21.jpg");

	    return "dashboard";
	}
}
