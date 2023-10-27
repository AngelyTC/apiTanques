package com.example.demo.repositories;

import com.example.demo.models.Tanque;
import jakarta.transaction.Transactional;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Date;

@Repository
public interface TanqueRepository  extends JpaRepository<Tanque, Integer> {
    @Transactional
    @Modifying
    @Query("UPDATE Tanque c set c.capacidad = :capacidad where c.id = :id")
    void updateCapacidad(@Param("capacidad") String capacidad, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanque c set c.nivel_actual = :nivel_actual where c.id = :id")
    void updateNivel(@Param("nivel_actual") Double nivel_actual, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanque c set c.tipo_gasolina = :tipo_gasolina where c.id = :id")
    void updateTipoGasolina(@Param("tipo_gasolina") String tipo_gasolina, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanque c set c.ubicacion = :ubicacion where c.id = :id")
    void updateUbicacion(@Param("ubicacion") String ubicacion, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanque c set c.precio_galon = :precio_galon where c.id = :id")
    void updatePrecio(@Param("precio_galon") Double precio_galon, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanque c set c.Id_Cliente = :Id_Cliente where c.id = :id")
    void updateCliente(@Param("Id_Cliente") Integer Id_Cliente, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanque c set c.tipo_pago = :tipo_pago where c.id = :id")
    void updateTipoPago(@Param("tipo_pago") String tipo_pago, @Param("id") Integer id);

    @Transactional
    @Modifying
    @Query("UPDATE Tanque c set c.fecha = :fecha where c.id = :id")
    void updateFecha(@Param("fecha") Date fecha, @Param("id") Integer id);
}
