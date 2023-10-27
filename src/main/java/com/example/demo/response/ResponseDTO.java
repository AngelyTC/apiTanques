package com.example.demo.response;

import com.example.demo.services.TanqueService;
import com.fasterxml.jackson.annotation.JsonIgnoreProperties;
import com.fasterxml.jackson.annotation.JsonInclude;
import com.fasterxml.jackson.annotation.JsonProperty;

@JsonInclude(JsonInclude.Include.NON_NULL)
@JsonIgnoreProperties(ignoreUnknown = true)

public class ResponseDTO {
    @JsonProperty("response")
    private String response;
    @JsonProperty("role")
    private RoleResponse role;
    @JsonProperty("user")
    private UserResponse user;
    @JsonProperty("paint")
    private PaintResponse paint;
    @JsonProperty("cocina")
    private CocinaResponse cocina;
    @JsonProperty("tanque")
    private TanqueResponse tanque;

    public String getResponse() {
        return response;
    }

    public void setResponse(String response) {
        this.response = response;
    }

    public RoleResponse getRole() {
        return role;
    }

    public void setRole(RoleResponse role) {
        this.role = role;
    }

    public UserResponse getUser() {
        return user;
    }

    public void setUser(UserResponse user) {
        this.user = user;
    }

    public PaintResponse getPaint() {
        return paint;
    }

    public void setPaint(PaintResponse paint) {
        this.paint = paint;
    }

    public CocinaResponse getCocina() {
        return cocina;
    }

    public void setCocina(CocinaResponse cocina) {
        this.cocina = cocina;
    }

    public TanqueResponse getTanque() {
        return tanque;
    }

    public void setTanque(TanqueResponse tanque) {
        this.tanque = tanque;
    }
}
