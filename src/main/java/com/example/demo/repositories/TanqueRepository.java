package com.example.demo.repositories;

import com.example.demo.models.Tanque;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface TanqueRepository  extends JpaRepository<Tanque, Integer> {
}
