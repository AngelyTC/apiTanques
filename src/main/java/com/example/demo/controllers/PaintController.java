package com.example.demo.controllers;

import com.example.demo.models.Paint;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.ResponseDTO;
import com.example.demo.services.PaintService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.Optional;

@RestController
@RequestMapping("/paint")
public class PaintController {
    @Autowired
    PaintService paintService;

    @GetMapping("/paint")
    public ArrayList<Paint> obtenerPaint(){
        return paintService.obtenerPaints();
    }

    @GetMapping("/paint/{id}")
    public Optional<Paint> obtenerId(@PathVariable("id") Integer id){
        return this.paintService.obtenerId(id);
    }
    @PostMapping("/paintCreate")
    public ResponseEntity<ResponseDTO> guardarPaint(@RequestBody RequestDTO requestDTO){
        return this.paintService.guardarPaint(requestDTO);
    }
    @PutMapping("/actualizar")
    public ResponseEntity<ResponseDTO> actualizarPaint(@RequestBody RequestDTO requestDTO){
        return this.paintService.actualizarPaint(requestDTO);
    }

    @DeleteMapping("/delete")
    public ResponseEntity<ResponseDTO> eliminarPaint(@RequestBody RequestDTO requestDTO){
        return this.paintService.eliminarPaint(requestDTO);
    }
}
