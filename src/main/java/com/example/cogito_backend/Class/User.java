package com.example.cogito_backend.Class;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="users")
public class User {
    @Id
    private Long id;
    private String phoneNumber;
    private String password;
    private String firstName;
    private String lastName;
    private String description;
    private Timestamp birthDate;
    private String avatar;
    private String education;
    private Timestamp createdAt;
}
