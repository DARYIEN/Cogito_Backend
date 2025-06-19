package com.example.cogito_backend.Repo;

import com.example.cogito_backend.Entity.Rating;
import com.example.cogito_backend.Entity.User;
import com.example.cogito_backend.Entity.UserRating;
import com.example.cogito_backend.Entity.UserRatingId;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface UserRatingRepo extends JpaRepository<UserRating, UserRatingId> {

    List<UserRating> findByUserId(Long userId);
    List<UserRating> findByRatingId(Long ratingId);
    void deleteAllByUser(User user);
    void deleteAllByRating(Rating rating);
}

