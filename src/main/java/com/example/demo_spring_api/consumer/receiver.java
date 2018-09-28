package com.example.demo_spring_api.consumer;

import org.springframework.kafka.annotation.KafkaListener;

public class receiver {
    @KafkaListener(topics = "test")
    public void receive (String payload) {
        System.out.println(payload);
    }
}
