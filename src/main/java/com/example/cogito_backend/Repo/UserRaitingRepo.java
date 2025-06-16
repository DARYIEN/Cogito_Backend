package com.example.cogito_backend.Repo;

import com.example.cogito_backend.Class.Raiting;
import com.example.cogito_backend.Class.UserRaiting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.Collection;

@Repository
public interface UserRaitingRepo extends JpaRepository<UserRaiting,Integer> {

    Collection<Object> getUserRaitingsByUserId(Long userId);
}

