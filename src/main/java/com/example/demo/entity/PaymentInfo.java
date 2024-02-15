package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
public class PaymentInfo {

    private String id;
    private String cardToken;
    private String pixKey;
}
