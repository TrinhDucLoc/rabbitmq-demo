package com.loctrinh.rabbitmq.entity;

import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
public class Item {
    private long id;
    private String itemName;
    private String categoryName;
    private String description;
}
