package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class ProductController {
	@Autowired
	private ProductAsyncService service;
	@GetMapping("/getProduct")
	public String getProduct() {
		service.fetchProduct();
		return "Request Accepted, Product is being fetched";
	}
}
