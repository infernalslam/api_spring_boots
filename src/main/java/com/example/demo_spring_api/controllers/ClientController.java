package com.example.demo_spring_api.controllers;

import com.example.demo_spring_api.models.Quote;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
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
//    Simple validation api: http://localhost:3000/api/user/tak
    @GetMapping("/user/{name}")
    public String getUser (@PathVariable(value = "name", required = true) String name) {
        return  name;
    }
//    simple validation api: http://localhost:3000/api/admin?name=tak
    @GetMapping("/admin")
    public ResponseEntity<?> queryPerson(@RequestParam(value = "name", required = false) String query) {
        return new ResponseEntity<>(query, HttpStatus.OK);
    }
}
