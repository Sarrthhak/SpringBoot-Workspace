package com.example.demo.bankconsumer;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cloud.client.ServiceInstance;
import org.springframework.cloud.client.discovery.DiscoveryClient;
import org.springframework.stereotype.Component;
import org.springframework.web.client.RestTemplate;

@Component
public class BankRestConsumer {

    @Autowired
    private DiscoveryClient discoveryClient;


    public String getBankData(){

        List<ServiceInstance> instances =
                discoveryClient.getInstances("BankService");


        if(instances.isEmpty()){
            return "Bank Service unavailable";
        }


        ServiceInstance instance = instances.get(0);

        String url = instance.getUri() + "/bank/getData";


        RestTemplate restTemplate = new RestTemplate();

        return restTemplate.getForObject(
                url,
                String.class
        );
    }
}