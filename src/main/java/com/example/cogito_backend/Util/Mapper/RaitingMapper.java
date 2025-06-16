package com.example.cogito_backend.Util.Mapper;

import com.example.cogito_backend.Class.Raiting;
import com.example.cogito_backend.Dto.RaitingDto;

public class RaitingMapper {

    public static RaitingDto toDto(Raiting raiting) {
        if (raiting == null) {
            return null;
        }
        RaitingDto dto = new RaitingDto();
        dto.setId(raiting.getId());
        dto.setTitle(raiting.getTitle());
        dto.setDescription(raiting.getDescription());
        dto.setAvatar(raiting.getAvatar());
        dto.setCreatedAt(raiting.getCreatedAt());
        return dto;
    }

    public static Raiting toEntity(RaitingDto dto) {
        if (dto == null) {
            return null;
        }
        Raiting raiting = new Raiting();
        raiting.setId(dto.getId());
        raiting.setTitle(dto.getTitle());
        raiting.setDescription(dto.getDescription());
        raiting.setAvatar(dto.getAvatar());
        raiting.setCreatedAt(dto.getCreatedAt());
        return raiting;
    }
}
