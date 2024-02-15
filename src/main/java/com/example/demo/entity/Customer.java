package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Document(collection = "customer")
@Getter
@Setter
public class Customer {

    @Id
    private String id;
    private String name;
    private List<Address> addresses;
    private List<Contact> contacts;
    private PersonalDocuments personalDocuments;
}
