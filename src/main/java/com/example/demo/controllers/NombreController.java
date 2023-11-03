package com.example.demo.controllers;

import com.example.demo.models.Nombre;
import com.example.demo.models.Paint;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.ResponseDTO;
import com.example.demo.services.NombreService;
import com.example.demo.services.PaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/nombre")
public class NombreController {
    @Autowired
    NombreService nombreService;

    @GetMapping("/getNombre")
    public ArrayList<Nombre> obtenerNombre(){
        return nombreService.obtenerNombre();
    }

    @GetMapping("/nombre/{id}")
    public Optional<Nombre> obtenerId(@PathVariable("id") Integer id){
        return this.nombreService.obtenerId(id);
    }

    @PostMapping("/nombreCreate")
    public ResponseEntity<ResponseDTO> guardarNombre(@RequestBody RequestDTO requestDTO){
        return this.nombreService.guardarNombre(requestDTO);
    }
    @PutMapping("/actualizar")
    public ResponseEntity<ResponseDTO> actualizarNombre(@RequestBody RequestDTO requestDTO){
        return this.nombreService.actualizarNombre(requestDTO);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> eliminarNombre(@RequestBody RequestDTO requestDTO){
        return this.nombreService.eliminarNombre(requestDTO);
    }
}
