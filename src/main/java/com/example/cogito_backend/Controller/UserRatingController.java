package com.example.cogito_backend.Controller;

import com.example.cogito_backend.Dto.RatingDto;
import com.example.cogito_backend.Dto.UserDto;
import com.example.cogito_backend.Service.UserRatingService;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@Validated
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserRatingController {

    final private UserRatingService userRatingService;
    @GetMapping("/users/{id}/ratings")
    public ResponseEntity<List<RatingDto>> getUserRatings(@Positive(message = "id < 0") @PathVariable Long id) {
        return ResponseEntity.ok(userRatingService.getUserRatings(id));
    }

    @GetMapping("/ratings/{id}/users")
    public ResponseEntity<List<UserDto>> getRatingUsers(@Positive(message = "id < 0") @PathVariable Long id) {
        return ResponseEntity.ok(userRatingService.getRatingUsers(id));
    }

    @PostMapping("/users/{userId}/ratings/{ratingId}")
    public ResponseEntity<Void> joinRating(@Positive(message = "userId < 0") @PathVariable Long userId, @Positive(message = "ratingId < 0") @PathVariable Long ratingId) {
        userRatingService.joinRating(userId, ratingId);
        return ResponseEntity.ok().build();
    }

    @DeleteMapping("/users/{userId}/ratings/{ratingId}")
    public ResponseEntity<Void> leaveRating(@Positive(message = "userId < 0") @PathVariable Long userId, @Positive(message = "ratingId < 0") @PathVariable Long ratingId) {
        userRatingService.leaveRating(userId, ratingId);
        return ResponseEntity.ok().build();
    }

}
