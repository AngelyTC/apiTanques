package com.example.demo.repositories;

import com.example.demo.models.Nombre;
import com.example.demo.models.Paint;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

@Repository
public interface NombreRepository extends JpaRepository<Nombre, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Nombre c set c.Nombre = :Nombre where c.id = :id")
    void updateNombre(@Param("Nombre") String nombre, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Nombre c set c.Apellido = :Apellido where c.id = :id")
    void updateApellido(@Param("Apellido") String apellido, @Param("id") Integer id);

}
