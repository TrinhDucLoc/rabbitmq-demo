package com.loctrinh.rabbitmq.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Corporation {
    private int id;
    private String fullName;
    private String address;
}
