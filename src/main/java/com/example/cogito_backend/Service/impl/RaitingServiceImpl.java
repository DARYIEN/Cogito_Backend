package com.example.cogito_backend.Service.impl;

import com.example.cogito_backend.Class.Raiting;
import com.example.cogito_backend.Class.User;
import com.example.cogito_backend.Dto.RaitingDto;
import com.example.cogito_backend.Repo.RaitingRepo;
import com.example.cogito_backend.Service.RaitingService;
import com.example.cogito_backend.Util.Mapper.RaitingMapper;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@RequiredArgsConstructor
public class RaitingServiceImpl implements RaitingService {

    final private RaitingRepo raitingRepo;

    @Override
    public List<RaitingDto> getAllRaitings() {
        return raitingRepo.findAll().stream().map(RaitingMapper::toDto).collect(Collectors.toList());
    }

    @Override
    public RaitingDto getRaiting(Long id) {
        return null;
    }

    @Override
    public RaitingDto createRaiting(Long id) {
        return null;
    }

    @Override
    public RaitingDto updateRaiting(Long id) {
        return null;
    }

    @Override
    public boolean deleteRaiting(Long id) {
        return false;
    }
}
