package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;

@Getter
@Setter
public class Contact {

    @Id
    private String id;
    private String phoneNumber;
    private boolean isWhatsApp;
    private String email;
}
