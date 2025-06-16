package com.example.cogito_backend.Service.impl;

import com.example.cogito_backend.Class.Raiting;
import com.example.cogito_backend.Dto.RaitingDto;
import com.example.cogito_backend.Dto.UserDto;
import com.example.cogito_backend.Repo.RaitingRepo;
import com.example.cogito_backend.Repo.UserRaitingRepo;
import com.example.cogito_backend.Repo.UserRepo;
import com.example.cogito_backend.Service.UserRaitingService;
import com.example.cogito_backend.Util.Mapper.RaitingMapper;
import com.example.cogito_backend.Util.Mapper.UserMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class UserRaitingServiceImpl implements UserRaitingService {

    private final UserRepo userRepo;
    private final RaitingRepo raitingRepo;
    private final UserRaitingRepo userRaitingRepo;

    @Override
    public List<RaitingDto> getUserRaitings(Long id) {
        Collection<Object> raitings =  userRaitingRepo.getUserRaitingsByUserId(id);
        if (!raitings.isEmpty()) {
            List<RaitingDto> raitings2 = raitings.stream().map(o -> (Raiting) o).map(RaitingMapper::toDto).toList();
            return raitings2;
        }
       return null;
    }

    @Override
    public List<UserDto> getRaitingUsers(Long id) {
        return List.of();
    }

    @Override
    public RaitingDto createRaiting(Long id) {
        return null;
    }

    @Override
    public RaitingDto updateRaiting(Long id, RaitingDto raitingDto) {
        return null;
    }

    @Override
    public boolean deleteRaiting(Long id) {
        return false;
    }
}
