package com.loctrinh.rabbitmq.config;

import org.springframework.amqp.core.*;
import org.springframework.amqp.rabbit.connection.ConnectionFactory;
import org.springframework.amqp.rabbit.core.RabbitTemplate;
import org.springframework.amqp.support.converter.Jackson2JsonMessageConverter;
import org.springframework.amqp.support.converter.MessageConverter;
import org.springframework.context.annotation.Bean;

public class MessagingConfig {
    // queue, exchange, routing-key
    public static final String QUEUE = "rabbit-queue";
    public static final String EXCHANGE = "rabbit-exchange";
    public static final String ROUTING_KEY = "rabbit-routing-key";

    // queue
    @Bean
    public Queue queue() {
        return new Queue(QUEUE, true);
    }

    // exchange
    @Bean
    public Exchange exchange() {
        return new TopicExchange(EXCHANGE);
    }

    // blind
    @Bean
    public Binding binding(Queue queue, TopicExchange exchange) {
        return BindingBuilder.bind(queue).to(exchange).with(ROUTING_KEY);
    }

    @Bean
    public MessageConverter converter() {
        return new Jackson2JsonMessageConverter();
    }

    @Bean
    public AmqpTemplate template(ConnectionFactory connectionFactory) {
        final RabbitTemplate rabbitTemplate = new RabbitTemplate(connectionFactory);
        rabbitTemplate.setMessageConverter(converter());
        return rabbitTemplate;
    }
}
