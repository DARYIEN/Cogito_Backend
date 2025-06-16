package com.example.cogito_backend.Service;

import com.example.cogito_backend.Class.Raiting;
import com.example.cogito_backend.Dto.RaitingDto;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public interface RaitingService {
    public List<RaitingDto> getAllRaitings();
    public RaitingDto getRaiting(Long id);
    public RaitingDto createRaiting(Long id);
    public RaitingDto updateRaiting(Long id);
    public boolean deleteRaiting(Long id);

}
