package com.example.cogito_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

@Entity
@Data
@Table(name ="users_roles")
public class UserRole {
    @EmbeddedId
    private UserRoleId id;

    @ManyToOne
    @MapsId("userId")
    private User user;

    @ManyToOne
    @MapsId("roleId")
    private Role role;
}
