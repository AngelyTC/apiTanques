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

    @GetMapping("/getTanque")
    public ArrayList<Tanque> obtenerPaint(){
        return tanqueService.obtenerTanques();
    }
    @GetMapping("/Tanque/{id}")
    public Optional<Tanque> obtenerId(@PathVariable("id") Integer id){
        return this.tanqueService.obtenerId(id);
    }

    @PostMapping("/tanqueCreate")
    public ResponseEntity<ResponseDTO> guardarTaqnue(@RequestBody RequestDTO requestDTO){
        return this.tanqueService.guardarTanque(requestDTO);
    }
}
