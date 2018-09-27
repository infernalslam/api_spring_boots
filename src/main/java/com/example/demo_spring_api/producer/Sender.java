package com.example.demo_spring_api.producer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;

public class Sender {

    @Autowired
    private KafkaTemplate<String, String> KafkaTemplate;
    public void send(String topic, String payload) {
        KafkaTemplate.send(topic, payload);
    }
}
