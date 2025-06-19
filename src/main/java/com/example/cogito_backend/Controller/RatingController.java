package com.example.cogito_backend.Controller;

import com.example.cogito_backend.Dto.RatingDto;
import com.example.cogito_backend.Service.RatingService;
import jakarta.validation.Valid;
import jakarta.validation.constraints.Positive;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpEntity;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/api/ratings")
@Validated
@RequiredArgsConstructor
public class RatingController {

    final private RatingService ratingService;

    @GetMapping
    public ResponseEntity<List<RatingDto>> getAllRatings() {
        return ResponseEntity.ok(ratingService.getAllRatings());
    }
    @GetMapping("/{id}")
    public ResponseEntity<RatingDto> getRating(@Positive(message = "id < 0") @PathVariable Long id) {
        return ResponseEntity.ok(ratingService.getRating(id));
    }
    @PostMapping
    public ResponseEntity<RatingDto> createRating(@Valid @RequestBody RatingDto ratingDto) {
        return ResponseEntity.ok(ratingService.createRating(ratingDto));
    }
    @PatchMapping
    public ResponseEntity<RatingDto> updateRating(@Valid @RequestBody RatingDto ratingDto) {
        return ResponseEntity.ok(ratingService.updateRating(ratingDto));
    }
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteRating(@Positive(message = "id < 0") @PathVariable Long id) {
        ratingService.deleteRating(id);
        return ResponseEntity.ok().build();
    }

}

