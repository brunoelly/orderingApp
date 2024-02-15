package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.time.LocalDateTime;
import java.util.List;

@Document(collection = "orders")
@Getter
@Setter
public class Order {
    @Id
    private String id;
    private String userId;
    private List<OrderItem> items;
    private LocalDateTime orderCreatedAt;
    private String orderStatus;
    private Double total;

}