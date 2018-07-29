package com.example.demo;

import com.netflix.hystrix.contrib.javanica.annotation.HystrixCommand;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;

@Service
class SomeTrafficGenerator {

    private final RestTemplate restTemplate;

    SomeTrafficGenerator(RestTemplate restTemplate) {
        this.restTemplate = restTemplate;
    }

    @Scheduled(fixedDelay = 10000)
    @HystrixCommand
    void makeSomeHit() {
        restTemplate.getForObject("https://www.google.com", String.class);
    }

}