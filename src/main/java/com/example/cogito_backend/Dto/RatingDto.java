package com.example.cogito_backend.Dto;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class RatingDto {

    private Long id;

    @NotBlank(message = "Заголовок рейтинга не должен быть пустым")
    @Size(max = 100, message = "Заголовок не должен превышать 100 символов")
    private String title;

    @Size(max = 500, message = "Описание не должно превышать 500 символов")
    private String description;

    @Size(max = 255, message = "Аватар не должен превышать 255 символов")
    private String avatar;

    private Timestamp createdAt;
}
