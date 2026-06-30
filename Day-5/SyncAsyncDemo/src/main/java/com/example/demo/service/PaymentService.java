package com.example.demo.service;

import org.springframework.stereotype.Service;


@Service
public class PaymentService {


	public String processPayment() throws InterruptedException {

		System.out.println("Payment Started");


		Thread.sleep(5000);


		System.out.println("Payment Completed");


		return "Payment Successful";

	}

}