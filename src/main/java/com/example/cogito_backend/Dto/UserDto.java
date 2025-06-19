package com.example.cogito_backend.Dto;

import jakarta.validation.constraints.*;
import lombok.Data;

import java.sql.Timestamp;

@Data
public class UserDto {

    private Long id;

    @NotBlank(message = "Имя не должно быть пустым")
    @Size(max = 50, message = "Имя не должно превышать 50 символов")
    private String firstName;

    @NotBlank(message = "Фамилия не должна быть пустой")
    @Size(max = 50, message = "Фамилия не должна превышать 50 символов")
    private String lastName;

    @Size(max = 1000, message = "Описание не должно превышать 1000 символов")
    private String description;

    @Past(message = "Дата рождения должна быть в прошлом")
    private Timestamp birthDate;

    @Size(max = 255, message = "Аватар не должен превышать 255 символов")
    private String avatar;

    @Size(max = 255, message = "Образование не должно превышать 255 символов")
    private String education;

    private Timestamp createdAt;
}
