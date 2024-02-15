package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "orderItem")
@Getter
@Setter
public class OrderItem {

    private String productId;
    private Integer quantity;
    private Double price;
}
