package com.example.demo_spring_api.controllers;

import com.example.demo_spring_api.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestTemplate;

@RestController
@RequestMapping("/api")
public class ClientController {
    @GetMapping("/")
    public ResponseEntity<Quote> getQuote () {
        String uri = "http://gturnquist-quoters.cfapps.io/api/random";
        RestTemplate restTemplate = new RestTemplate();
        Quote quote = restTemplate.getForObject(uri, Quote.class);
        return  new ResponseEntity<>(quote, HttpStatus.OK);
    }
}
