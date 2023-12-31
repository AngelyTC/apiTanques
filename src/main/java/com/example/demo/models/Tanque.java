package com.example.demo.models;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.sql.Date;
import java.sql.Timestamp;
@Entity
@Table(name = "tanques")
public class Tanque {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)

    private Integer id;
    private  String capacidad;
    private Double nivel_actual;
    private String tipo_gasolina;
    private String ubicacion;
    private Double precio_galon;
    private Integer Id_Cliente;
    private String tipo_pago;
    private Date fecha;
    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCapacidad() {
        return capacidad;
    }

    public void setCapacidad(String capacidad) {
        this.capacidad = capacidad;
    }

    public Double getNivel_actual() {
        return nivel_actual;
    }

    public void setNivel_actual(Double nivel_actual) {
        this.nivel_actual = nivel_actual;
    }

    public String getTipo_gasolina() {
        return tipo_gasolina;
    }

    public void setTipo_gasolina(String tipo_gasolina) {
        this.tipo_gasolina = tipo_gasolina;
    }

    public String getUbicacion() {
        return ubicacion;
    }

    public void setUbicacion(String ubicacion) {
        this.ubicacion = ubicacion;
    }

    public Double getPrecio_galon() {
        return precio_galon;
    }

    public void setPrecio_galon(Double precio_galon) {
        this.precio_galon = precio_galon;
    }

    public Integer getId_Cliente() {
        return Id_Cliente;
    }

    public void setId_Cliente(Integer id_Cliente) {
        Id_Cliente = id_Cliente;
    }

    public String getTipo_pago() {
        return tipo_pago;
    }

    public void setTipo_pago(String tipo_pago) {
        this.tipo_pago = tipo_pago;
    }

    public Date getFecha() {
        return fecha;
    }

    public void setFecha(Date fecha) {
        this.fecha = fecha;
    }

}
