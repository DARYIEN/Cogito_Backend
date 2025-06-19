package com.example.cogito_backend.Service.impl;

import com.example.cogito_backend.Entity.User;
import com.example.cogito_backend.Dto.UserDto;
import com.example.cogito_backend.Exception.RatingNotFoundException;
import com.example.cogito_backend.Exception.UserNotFoundException;
import com.example.cogito_backend.Repo.UserRatingRepo;
import com.example.cogito_backend.Repo.UserRepo;
import com.example.cogito_backend.Service.UserService;
import com.example.cogito_backend.Util.Mapper.UserMapper;
import jakarta.transaction.Transactional;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final UserRatingRepo userRatingRepo;

    @Override
    public UserDto getUser(Long id) {
        return UserMapper.toDto(userRepo.findById(id).orElseThrow(()->new UserNotFoundException("User not found")));
    }

    @Override
    public List<UserDto> getAllUsers() {
        return userRepo.findAll().stream().map(UserMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public UserDto createUser (UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        user.setId(null);
        return UserMapper.toDto(userRepo.save(user));


    }

    @Override
    public UserDto updateUser (UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        if (userRepo.findById(user.getId()).isEmpty()) {
            throw new UserNotFoundException("User not found");
        }
        return UserMapper.toDto(userRepo.save(user));
    }

    @Transactional
    public void deleteUser(Long id) {
        Optional<User> user = userRepo.findById(id);
        if (user.isPresent()) {

            userRatingRepo.deleteAllByUser(user.get());
            userRepo.deleteById(id);
        } else {
            throw new RatingNotFoundException("User not found");
        }
    }
}
