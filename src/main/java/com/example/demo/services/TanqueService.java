package com.example.demo.services;


import com.example.demo.models.Tanque;
import com.example.demo.repositories.TanqueRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class TanqueService {
    @Autowired
    TanqueRepository tanqueRepository;

    public ArrayList<Tanque> obtenerTanques(){
        return (ArrayList<Tanque>) tanqueRepository.findAll();
    }
    //get
    public Optional<Tanque> obtenerId(Integer id){
        if(tanqueRepository.existsById(id)){
            return tanqueRepository.findById(id);
        }else{
            return Optional.empty();
        }
    }


}
