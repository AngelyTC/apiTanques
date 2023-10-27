package com.example.demo.controllers;


import com.example.demo.models.Cocina;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.ResponseDTO;
import com.example.demo.services.CocinaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@RestController
@RequestMapping("/cocina")
public class CocinaController {
    @Autowired
    CocinaService cocinaService;

    @GetMapping("/cocina")
    public ArrayList<Cocina> obtenerCocina(){
        return cocinaService.obtenerCocina();
    }

    @PostMapping("/cocinaCreate")
    public ResponseEntity<ResponseDTO> guardarCocina(@RequestBody RequestDTO requestDTO){
        return this.cocinaService.guardarCocina(requestDTO);
    }
}
