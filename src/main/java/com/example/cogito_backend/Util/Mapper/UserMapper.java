package com.example.cogito_backend.Util.Mapper;

import com.example.cogito_backend.Entity.User;
import com.example.cogito_backend.Dto.UserDto;

public class UserMapper {

    public static UserDto toDto(User user) {
        if (user == null) {
            return null;
        }
        UserDto dto = new UserDto();
        dto.setId(user.getId());
        dto.setFirstName(user.getFirstName());
        dto.setLastName(user.getLastName());
        dto.setDescription(user.getDescription());
        dto.setBirthDate(user.getBirthDate());
        dto.setAvatar(user.getAvatar());
        dto.setEducation(user.getEducation());
        dto.setCreatedAt(user.getCreatedAt());
        return dto;
    }

    public static User toEntity(UserDto dto) {
        if (dto == null) {
            return null;
        }
        User user = new User();
        user.setId(dto.getId());
        user.setFirstName(dto.getFirstName());
        user.setLastName(dto.getLastName());
        user.setDescription(dto.getDescription());
        user.setBirthDate(dto.getBirthDate());
        user.setAvatar(dto.getAvatar());
        user.setEducation(dto.getEducation());
        user.setCreatedAt(dto.getCreatedAt());
        return user;
    }
}
