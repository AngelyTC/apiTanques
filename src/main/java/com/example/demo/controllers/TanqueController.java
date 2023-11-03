package com.example.demo.controllers;

import com.example.demo.models.Paint;
import com.example.demo.models.Tanque;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.ResponseDTO;
import com.example.demo.services.TanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/tanque")
public class TanqueController {
    @Autowired
    TanqueService tanqueService;
    public TanqueController(TanqueService tanqueService) {
        this.tanqueService = tanqueService;
    }
    @GetMapping("/getTanque")
    public ArrayList<Tanque> obtenerPaint(){
        return tanqueService.obtenerTanques();
    }
    @GetMapping("/Tanque/{id}")
    public Optional<Tanque> obtenerId(@PathVariable("id") Integer id){
        return this.tanqueService.obtenerId(id);
    }

    @GetMapping("/nivelActual/{id}")
    public Optional<Double> obtenerNivelActualPorId(@PathVariable("id") Integer id){
        return this.tanqueService.obtenerNivelActualPorId(id);
    }

    @PostMapping("/tanqueCreate")
    public ResponseEntity<ResponseDTO> guardarTaqnue(@RequestBody RequestDTO requestDTO){
        return this.tanqueService.guardarTanque(requestDTO);
    }
    @PutMapping("/actualizar")
    public ResponseEntity<ResponseDTO> actualizarTanque(@RequestBody RequestDTO requestDTO){
        return this.tanqueService.actualizarTanque(requestDTO);
    }

    @PutMapping("/actualizarNivel")
    public ResponseEntity<ResponseDTO> actualizarNivelTanque(@RequestBody RequestDTO requestDTO){
        return this.tanqueService.actualizarNivelTanque(requestDTO);
    }


    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> eliminarTanque(@RequestBody RequestDTO requestDTO){
        return this.tanqueService.eliminarTanque(requestDTO);
    }
}
