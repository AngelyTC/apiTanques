package com.example.demo.request;

import com.example.demo.models.*;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)
public class Request {
    @JsonProperty("user") //Para que el objeto se vea mas bonito en JSON
    private User user;
    @JsonProperty("role")
    private Role role;
    @JsonProperty("paint")
    private Paint paint;
    @JsonProperty("cocina")
    private Cocina cocina;
    @JsonProperty("tanque")
    private Tanque tanque;
    @JsonProperty("nuevo_nivel")
    private Double nuevoNivel;
    @JsonProperty("nombre")
    private Nombre nombre;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public Role getRole() {
        return role;
    }

    public void setRole(Role role) {
        this.role = role;
    }

    public Paint getPaint() {
        return paint;
    }

    public void setPaint(Paint paint) {
        this.paint = paint;
    }

    public Cocina getCocina() {
        return cocina;
    }

    public void setCocina(Cocina cocina) {
        this.cocina = cocina;
    }

    public Tanque getTanque() {
        return tanque;
    }
    public void setTanque(Tanque tanque) {
        this.tanque = tanque;
    }

    public Double getNuevoNivel() {
        return nuevoNivel;
    }

    public void setNuevoNivel(Double nuevoNivel) {
        this.nuevoNivel = nuevoNivel;
    }

    public Nombre getNombre() {
        return nombre;
    }

    public void setNombre(Nombre nombre) {
        this.nombre = nombre;
    }

}
