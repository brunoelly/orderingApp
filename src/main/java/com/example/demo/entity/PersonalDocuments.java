package com.example.demo.entity;

import lombok.Getter;
import lombok.Setter;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

@Getter
@Setter
public class PersonalDocuments {

    @Id
    private String id;
    private String cpfEncrypted;
    private String rgEncrypted;
    private String cnhEncrypted;
}
