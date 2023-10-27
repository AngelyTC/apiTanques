package com.example.demo.controllers;

import com.example.demo.models.Tanque;
import com.example.demo.services.TanqueService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController
@RequestMapping("/tanque")
public class TanqueController {
    @Autowired
    TanqueService tanqueService;

    @GetMapping("/get")
    public ArrayList<Tanque> obtenerPaint(){
        return tanqueService.obtenerTanques();
    }

}
