package com.example.cogito_backend.Service;

import com.example.cogito_backend.Dto.RaitingDto;
import com.example.cogito_backend.Dto.UserDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface UserRaitingService {

    public List<RaitingDto> getUserRaitings(Long id);
    public List<UserDto> getRaitingUsers(Long id);
    public RaitingDto createRaiting(Long id);
    public RaitingDto updateRaiting(Long id, RaitingDto raitingDto);
    public boolean deleteRaiting(Long id);
}
