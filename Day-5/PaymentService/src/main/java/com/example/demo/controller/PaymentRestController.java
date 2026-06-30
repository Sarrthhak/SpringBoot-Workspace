package com.example.demo.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.demo.bankconsumer.BankRestConsumer;

@RestController
public class PaymentRestController {


    @Autowired
    private BankRestConsumer bankConsumer;


    @GetMapping("/payment/data")
    public String getPaymentData() {

        return "FROM PAYMENT SERVICE -> "
                + bankConsumer.getBankData();

    }

}