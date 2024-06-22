package com.loctrinh.rabbitmq.controller;

import com.loctrinh.rabbitmq.entity.Item;
import com.loctrinh.rabbitmq.service.RabbitMqService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MsgController {
    private final RabbitMqService rabbitMqService;

    public MsgController(RabbitMqService rabbitMqService) {
        this.rabbitMqService = rabbitMqService;
    }

    @PostMapping("/items")
    public ResponseEntity<String> postMessage(@RequestBody Item item) {
        rabbitMqService.sendMessage(item);
        return new ResponseEntity<>("Push message to RabbitMQ", HttpStatus.CREATED);
    }
}
