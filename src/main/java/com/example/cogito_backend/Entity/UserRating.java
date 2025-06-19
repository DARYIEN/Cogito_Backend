package com.example.cogito_backend.Entity;

import jakarta.persistence.*;
import lombok.Data;

import java.sql.Timestamp;

@Entity
@Data
@Table(name ="users_ratings")
public class UserRating {

    @EmbeddedId
    private UserRatingId id;

    @ManyToOne(optional = false)
    @MapsId("userId")
    private User user;

    @ManyToOne(optional = false)
    @MapsId("ratingId")
    private Rating rating;

    @Column(nullable = false)
    private Integer position;

    @Column(nullable = false)
    private Integer score;

    @Column(name = "joined_at", nullable = false, updatable = false)
    private Timestamp joinedAt;

    @PrePersist
    protected void onCreate() {
        joinedAt = new Timestamp(System.currentTimeMillis());
    }
}


