package com.gft.sqslistener.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
public class ApiService {

    @Value("${gft.message-processor.endpoint}")
    private String endpoint;

    @Autowired
    private RestTemplate restTemplate;

    public void postToApi(String messageBody) {
        restTemplate.postForObject(endpoint, messageBody, String.class);
    }
}