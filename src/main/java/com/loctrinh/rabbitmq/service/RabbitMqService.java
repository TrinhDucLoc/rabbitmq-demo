package com.loctrinh.rabbitmq.service;

import com.loctrinh.rabbitmq.entity.Item;
import org.springframework.stereotype.Service;

@Service
public interface RabbitMqService {
    public void sendMessage(Item item);
}
