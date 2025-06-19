package com.example.cogito_backend.Util.Mapper;

import com.example.cogito_backend.Entity.Rating;
import com.example.cogito_backend.Dto.RatingDto;

public class RatingMapper {

    public static RatingDto toDto(Rating rating) {
        if (rating == null) {
            return null;
        }
        RatingDto dto = new RatingDto();
        dto.setId(rating.getId());
        dto.setTitle(rating.getTitle());
        dto.setDescription(rating.getDescription());
        dto.setAvatar(rating.getAvatar());
        dto.setCreatedAt(rating.getCreatedAt());
        return dto;
    }

    public static Rating toEntity(RatingDto dto) {
        if (dto == null) {
            return null;
        }
        Rating rating = new Rating();
        rating.setId(dto.getId());
        rating.setTitle(dto.getTitle());
        rating.setDescription(dto.getDescription());
        rating.setAvatar(dto.getAvatar());
        rating.setCreatedAt(dto.getCreatedAt());
        return rating;
    }
}
