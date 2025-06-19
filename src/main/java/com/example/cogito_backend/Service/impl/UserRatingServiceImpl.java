package com.example.cogito_backend.Service.impl;

import com.example.cogito_backend.Entity.Rating;
import com.example.cogito_backend.Entity.User;
import com.example.cogito_backend.Entity.UserRating;
import com.example.cogito_backend.Dto.RatingDto;
import com.example.cogito_backend.Dto.UserDto;
import com.example.cogito_backend.Entity.UserRatingId;
import com.example.cogito_backend.Exception.RatingNotFoundException;
import com.example.cogito_backend.Exception.UserAlreadyInRatingException;
import com.example.cogito_backend.Exception.UserNotFoundException;
import com.example.cogito_backend.Exception.UserRatingNotFoundException;
import com.example.cogito_backend.Repo.RatingRepo;
import com.example.cogito_backend.Repo.UserRatingRepo;
import com.example.cogito_backend.Repo.UserRepo;
import com.example.cogito_backend.Service.UserRatingService;
import com.example.cogito_backend.Util.Mapper.RatingMapper;
import com.example.cogito_backend.Util.Mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;


@Service
@RequiredArgsConstructor
public class UserRatingServiceImpl implements UserRatingService {

    private final UserRepo userRepo;
    private final RatingRepo ratingRepo;
    private final UserRatingRepo userRatingRepo;

    @Override
    public List<RatingDto> getUserRatings(Long id) {
        if (userRepo.findById(id).isPresent()) {
            List<Rating> ratings = userRatingRepo.findByUserId(id).stream().map(UserRating::getRating).toList();
            return ratings.stream().map(RatingMapper::toDto).toList();
        } else {
            throw new UserNotFoundException("User not found");
        }
    }

    @Override
    public List<UserDto> getRatingUsers(Long id) {
        if (ratingRepo.findById(id).isPresent()) {
            List<User> users = userRatingRepo.findByRatingId(id).stream().map(UserRating::getUser).toList();
            return users.stream().map(UserMapper::toDto).toList();
        } else {
            throw new RatingNotFoundException("Rating not found");
        }
    }

    @Override
    public void joinRating(Long userId, Long ratingId) {
        UserRating userRating = new UserRating();
        Optional<User> user = userRepo.findById(userId);
        Optional<Rating> rating = ratingRepo.findById(ratingId);
        UserRatingId id = new UserRatingId(userId, ratingId);
        if (user.isEmpty()) {
            throw new UserNotFoundException("User not found");
        } else if (rating.isEmpty()) {
            throw new RatingNotFoundException("Rating not found");
        } else if (userRatingRepo.findById(id).isEmpty()) {
            userRating.setId(id);
            userRating.setUser(user.get());
            userRating.setRating(rating.get());
            userRating.setScore(0);
            userRating.setPosition((userRatingRepo.findByRatingId(ratingId).stream().map(UserRating::getUser).toList()).size() + 1);
            userRatingRepo.save(userRating);
        } else {
            throw new UserAlreadyInRatingException("User is already in rating");
        }
    }

    @Override
    public void leaveRating(Long userId, Long ratingId) {
        UserRatingId id = new UserRatingId(userId, ratingId);
        if (userRatingRepo.findById(id).isPresent()) {
            userRatingRepo.deleteById(id);
        } else {
            throw new UserRatingNotFoundException("User is not in the rating");
        }
    }
}
