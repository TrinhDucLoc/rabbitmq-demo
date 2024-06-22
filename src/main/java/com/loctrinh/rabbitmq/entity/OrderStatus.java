package com.loctrinh.rabbitmq.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class OrderStatus {
    private Order order;
    private String status;
    private String message;

    public OrderStatus(Order order, String statusProcess, String s) {
    }
}
