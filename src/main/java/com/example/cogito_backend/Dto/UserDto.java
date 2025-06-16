package com.example.cogito_backend.Dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserDto {
    private Long id;
    private String firstName;
    private String lastName;
    private String description;
    private Timestamp birthDate;
    private String avatar;
    private String education;
    private Timestamp createdAt;
}
