package com.example.cogito_backend.Dto;

import lombok.Data;

import java.sql.Timestamp;

@Data
public class RaitingDto {
    private Long id;
    private String title;
    private String description;
    private String avatar;
    private Timestamp createdAt;
}
