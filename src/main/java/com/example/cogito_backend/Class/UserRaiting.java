package com.example.cogito_backend.Class;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.Data;

@Entity
@Data
@Table(name = "user_raitings")
public class UserRaiting {

    @Id
    private Long id;

    private Long userId;

    private Long raitingId;
}
