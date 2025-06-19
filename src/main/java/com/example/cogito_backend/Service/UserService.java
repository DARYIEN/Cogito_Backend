package com.example.cogito_backend.Service;

import com.example.cogito_backend.Dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserService {
    public UserDto getUser(Long id);
    public List<UserDto> getAllUsers();
    public UserDto createUser(UserDto userDto);
    public UserDto updateUser(UserDto userDto);
    public void deleteUser(Long id);
}
