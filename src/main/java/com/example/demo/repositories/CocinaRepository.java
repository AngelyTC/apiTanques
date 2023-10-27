package com.example.demo.repositories;

import com.example.demo.models.Cocina;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CocinaRepository extends JpaRepository<Cocina, Integer> {
}
