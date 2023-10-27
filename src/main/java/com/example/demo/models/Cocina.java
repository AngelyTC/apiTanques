package com.example.demo.models;

import jakarta.persistence.*;
@Entity
@Table(name = "cocinas")
public class Cocina {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(unique = true, nullable = false)

    private Integer id;
    private String Utencilio;
    private String Descripcion;
    private Integer Estado;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getUtencilio() {
        return Utencilio;
    }

    public void setUtencilio(String utencilio) {
        Utencilio = utencilio;
    }

    public String getDescripcion() {
        return Descripcion;
    }

    public void setDescripcion(String descripcion) {
        Descripcion = descripcion;
    }

    public Integer getEstado() {
        return Estado;
    }

    public void setEstado(Integer estado) {
        Estado = estado;
    }
}
