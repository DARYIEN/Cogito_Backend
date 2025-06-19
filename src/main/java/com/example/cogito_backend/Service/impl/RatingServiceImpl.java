package com.example.cogito_backend.Service.impl;

import com.example.cogito_backend.Dto.RatingDto;
import com.example.cogito_backend.Entity.Rating;
import com.example.cogito_backend.Exception.RatingNotFoundException;
import com.example.cogito_backend.Repo.RatingRepo;
import com.example.cogito_backend.Repo.UserRatingRepo;
import com.example.cogito_backend.Service.RatingService;
import com.example.cogito_backend.Util.Mapper.RatingMapper;
import jakarta.transaction.Transactional;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RatingServiceImpl implements RatingService {

    final private RatingRepo ratingRepo;
    final private UserRatingRepo userRatingRepo;

    @Override
    public List<RatingDto> getAllRatings() {
        return ratingRepo.findAll().stream().map(RatingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public RatingDto getRating(Long id) {
        return ratingRepo.findById(id).map(RatingMapper::toDto).orElseThrow(()->new RatingNotFoundException("Rating not found"));
    }

    @Override
    public RatingDto createRating(RatingDto ratingDto) {
        Rating rating = RatingMapper.toEntity(ratingDto);
        rating.setId(null);
        return RatingMapper.toDto(ratingRepo.save(rating));
    }

    @Override
    public RatingDto updateRating(RatingDto ratingDto) {
        Rating rating = RatingMapper.toEntity(ratingDto);
        if (ratingRepo.findById(rating.getId()).isEmpty()) {
            throw new RatingNotFoundException("Rating not found");
        }
        return RatingMapper.toDto(ratingRepo.save(rating));
    }

    @Transactional
    public void deleteRating(Long id) {
        Optional<Rating> rating = ratingRepo.findById(id);
        if (rating.isPresent()) {
            userRatingRepo.deleteAllByRating(rating.get());
            ratingRepo.deleteById(id);
        } else {
            throw new RatingNotFoundException("Rating not found");
        }

    }
}
