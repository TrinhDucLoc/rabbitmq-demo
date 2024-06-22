package com.loctrinh.rabbitmq.service.serviceImpl;

import com.loctrinh.rabbitmq.entity.Item;
import com.loctrinh.rabbitmq.service.RabbitMqService;
import org.springframework.amqp.core.AmqpTemplate;

public class RabbitMqServiceImpl implements RabbitMqService {
    private final String EXCHANGE = "items-exchange";
    private final String ROUTING_KEY = "items-routingKey";

    private final AmqpTemplate amqpTemplate;

    public RabbitMqServiceImpl(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @Override
    public void sendMessage(Item item) {
        amqpTemplate.convertAndSend(EXCHANGE, ROUTING_KEY, item);
    }
}
