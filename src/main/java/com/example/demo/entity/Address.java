package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Document(collection = "address")
@Getter
@Setter
public class Address {

    @Id
    private String id;
    private String street;
    private String number;
    private String neighborhood;
    private String city;
    private String state;
    private String country;
    private String zipCode;
}
