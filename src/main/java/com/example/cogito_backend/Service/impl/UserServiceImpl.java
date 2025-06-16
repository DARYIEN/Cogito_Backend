package com.example.cogito_backend.Service.impl;

import com.example.cogito_backend.Class.Raiting;
import com.example.cogito_backend.Class.User;
import com.example.cogito_backend.Dto.UserDto;
import com.example.cogito_backend.Repo.RaitingRepo;
import com.example.cogito_backend.Repo.UserRepo;
import com.example.cogito_backend.Service.UserService;
import com.example.cogito_backend.Util.Mapper.UserMapper;
import lombok.AllArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
@AllArgsConstructor
public class UserServiceImpl implements UserService {

    private final UserRepo userRepo;
    private final RaitingRepo raitingRepo;

    public UserDto getUser(Long id) {
        return UserMapper.toDto(userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found")));
    }

    public List<UserDto> getAllUsers() {
        List<User> users = userRepo.findAll();
        return users.stream().map(UserMapper::toDto).collect(Collectors.toList());

    }

    public UserDto createUser (UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        if (userRepo.findById(user.getId()).isPresent()) {
            throw new RuntimeException("User already exists");
        }
        return UserMapper.toDto(userRepo.save(user));
    }

    public UserDto updateUser (UserDto userDto) {
        User user = UserMapper.toEntity(userDto);
        return UserMapper.toDto(userRepo.save(userRepo.findById(user.getId()).orElseThrow(()->new RuntimeException("User not found"))));
    }
    public boolean deleteUser(Long id) {
        userRepo.deleteById(id);
        return userRepo.findById(id).isEmpty();
    }
//    public List<Raiting> getUserRaitings(Long id){
//       return raitingRepo.findRaitingBy(userRepo.findById(id).orElseThrow(()->new RuntimeException("User not found")));
//    }
}
