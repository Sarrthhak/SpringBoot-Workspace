package com.example.demo.service;


import org.springframework.scheduling.annotation.Async;
import org.springframework.stereotype.Service;


@Service
public class EmailService {


	@Async
	public void sendEmail() throws InterruptedException {


		System.out.println("Email sending started");


		Thread.sleep(7000);


		System.out.println("Email Sent");

	}

}