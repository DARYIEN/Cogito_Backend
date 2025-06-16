package com.example.cogito_backend.Controller;

import com.example.cogito_backend.Class.Raiting;
import com.example.cogito_backend.Dto.RaitingDto;
import com.example.cogito_backend.Service.UserRaitingService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;
@Controller
@RequiredArgsConstructor
@RequestMapping("/api")
public class UserRaitingController {

    final private UserRaitingService userRaitingService;
    @GetMapping("/users/{id}/raitings")
    public ResponseEntity<List<RaitingDto>> getUserRaitings(@PathVariable Long id) {
        return ResponseEntity.ok(userRaitingService.getUserRaitings(id));
    }
//
//    @GetMapping("/raitings/{id}/users")
//    public ResponseEntity<Raiting> getRaitingUsers(@PathVariable Long id) {
//        return ResponseEntity.ok(userRaitingService.getRaitingUsers(id));
//    }
//
//    @DeleteMapping("/users/{id}/raitings/{id}")
//    public ResponseEntity<Void> leaveRaiting(@PathVariable Long userId, @PathVariable Long raitingId) {
//        if(userRaitingService.leaveRaiting(userId, raitingId)) {
//            return ResponseEntity.ok().build();
//        } else {
//            return ResponseEntity.notFound().build();
//        }
//    }
//    @PostMapping("/users/{id}/raitings/{id}")
//    public ResponseEntity<Raiting> joinRaiting(@PathVariable Long userId, @PathVariable Long raitingId) {
//        return ResponseEntity.ok(userRaitingService.joinRaiting(userId, raitingId));
//    }
}
