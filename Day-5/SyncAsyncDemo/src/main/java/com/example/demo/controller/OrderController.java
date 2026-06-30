package com.example.demo.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import com.example.demo.service.EmailService;
import com.example.demo.service.PaymentService;



@RestController
public class OrderController {


	@Autowired
	private PaymentService paymentService;


	@Autowired
	private EmailService emailService;



	@GetMapping("/order")
	public String placeOrder() throws InterruptedException {


		System.out.println("Order Received");


		//SYNC call
		String payment =
				paymentService.processPayment();



		//ASYNC call
		emailService.sendEmail();



		return payment + 
				" , Order Completed";

	}


}