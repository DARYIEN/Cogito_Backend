package com.example.cogito_backend.Service;

import com.example.cogito_backend.Dto.RatingDto;
import com.example.cogito_backend.Dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRatingService {

    public List<RatingDto> getUserRatings(Long id);
    public List<UserDto> getRatingUsers(Long id);
    public void joinRating(Long userId, Long ratingId);
    public void leaveRating(Long userId, Long ratingId);
}
