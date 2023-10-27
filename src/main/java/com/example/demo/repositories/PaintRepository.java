package com.example.demo.repositories;

import com.example.demo.models.Paint;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

@Repository
public interface PaintRepository  extends JpaRepository<Paint, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Paint c set c.color = :color where c.id = :id")
    void updateColor(@Param("color") String color, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Paint c set c.price = :price where c.id = :id")
    void updatePrice(@Param("price") Double price, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Paint c set c.description = :description where c.id = :id")
    void updateDescription(@Param("description") String description, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Paint c set c.status = :status where c.id = :id")
    void updateStatus(@Param("status") Integer status, @Param("id") Integer id);
}