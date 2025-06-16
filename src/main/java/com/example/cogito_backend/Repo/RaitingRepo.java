package com.example.cogito_backend.Repo;

import com.example.cogito_backend.Class.Raiting;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RaitingRepo extends JpaRepository<Raiting,Integer> {

}

