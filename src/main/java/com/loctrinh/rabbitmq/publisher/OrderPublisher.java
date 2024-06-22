package com.loctrinh.rabbitmq.publisher;

import com.loctrinh.rabbitmq.config.MessagingConfig;
import com.loctrinh.rabbitmq.entity.Order;
import com.loctrinh.rabbitmq.entity.OrderStatus;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.UUID;

@RestController
public class OrderPublisher {
    private final AmqpTemplate amqpTemplate;
    private final static String STATUS_PROCESS = "PROCESS";
    private final static String ORDER_PROCESS_MSG = "order placed successfully in ";

    public OrderPublisher(AmqpTemplate amqpTemplate) {
        this.amqpTemplate = amqpTemplate;
    }

    @PostMapping("")
    public String bookOrder(@RequestBody Order order, @PathVariable String restaurantName) {
        order.setId(UUID.randomUUID().toString());
        OrderStatus orderStatus = new OrderStatus(order, STATUS_PROCESS, ORDER_PROCESS_MSG + restaurantName);
        amqpTemplate.convertAndSend(MessagingConfig.EXCHANGE, MessagingConfig.ROUTING_KEY, orderStatus);
        return "Successfully published order";
    }
}
