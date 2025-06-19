package com.example.cogito_backend.Service;

import com.example.cogito_backend.Dto.RatingDto;
import com.example.cogito_backend.Entity.Rating;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RatingService {
    public List<RatingDto> getAllRatings();
    public RatingDto getRating(Long id);
    public RatingDto createRating(RatingDto ratingDto);
    public RatingDto updateRating(RatingDto ratingDto);
    public void deleteRating(Long id);

}
