package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class CocinaResponse {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("Utencilio")
    private String Utencilio;
    @JsonProperty("Descripcion")
    private String Descripcion;
    @JsonProperty("Estado")
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
