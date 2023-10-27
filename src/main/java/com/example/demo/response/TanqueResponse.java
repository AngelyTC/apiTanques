package com.example.demo.response;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

import java.sql.Date;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class TanqueResponse {
    @JsonProperty("id")
    private Integer id;
    @JsonProperty("capacidad")
    private String capacidad;
    @JsonProperty("nivel_actual")
    private Double nivel_actual;
    @JsonProperty("tipo_gasolina")
    private String tipo_gasolina;
    @JsonProperty("ubicacion")
    private String ubicacion;
    @JsonProperty("precio_galon")
    private Double precio_galon;
    @JsonProperty("Id_Cliente")
    private Integer Id_Cliente;
    @JsonProperty("tipo_pago")
    private String tipo_pago;
    @JsonProperty("fecha")
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
