package com.example.cogito_backend.Class;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;
import java.sql.Timestamp;

@Entity
@Data
@Table(name="raitings")
public class Raiting {
    @Id
    private Long id;
    private String title;
    private String description;
    private String avatar;
    private Timestamp createdAt;
}