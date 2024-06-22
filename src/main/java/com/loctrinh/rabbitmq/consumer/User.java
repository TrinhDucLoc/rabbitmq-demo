package com.loctrinh.rabbitmq.consumer;

import com.loctrinh.rabbitmq.config.MessagingConfig;
import com.loctrinh.rabbitmq.entity.OrderStatus;
import lombok.extern.log4j.Log4j2;
import org.springframework.amqp.rabbit.annotation.RabbitListener;

@Log4j2
public class User {
    @RabbitListener(queues = MessagingConfig.QUEUE)
    public void receive(OrderStatus orderStatus) {
        log.info("Message received from RabbitMQ: [{}]", orderStatus);
    }
}
