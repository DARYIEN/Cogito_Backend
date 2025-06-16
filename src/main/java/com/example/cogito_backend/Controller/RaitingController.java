package com.example.cogito_backend.Controller;

import com.example.cogito_backend.Dto.RaitingDto;
import com.example.cogito_backend.Service.RaitingService;
import com.example.cogito_backend.Service.UserService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/raitings")
@RequiredArgsConstructor
public class RaitingController {

//    final private RaitingService raitingService;
//
//    @GetMapping("")
//    public ResponseEntity<List<RaitingDto>> getAllRaitings() {
//        return ResponseEntity.ok(raitingService.getAllRaitings());
//    }
//    @GetMapping("/{id}")
//    public ResponseEntity<RaitingDto> getRaiting(Long id) {
//        return ResponseEntity.ok(raitingService.getRaitingById(id));
//    }
//    @PostMapping("/{id}")
//    public ResponseEntity<RaitingDto> createRaiting(RaitingDto raitingDto) {
//        return ResponseEntity.ok(raitingService.createRaiting(raitingDto));
//    }
//    @PatchMapping("/{id}")
//    public ResponseEntity<RaitingDto> updateRaiting(RaitingDto raitingDto) {
//        return ResponseEntity.ok(raitingService.updateRaiting(raitingDto));
//    }
//    @DeleteMapping("/{id}")
//    public ResponseEntity<Void> deleteRaiting(Long id) {
//        if(raitingService.deleteRaiting(id)) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }

}

