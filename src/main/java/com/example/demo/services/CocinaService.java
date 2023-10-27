package com.example.demo.services;

import com.example.demo.models.Cocina;
import com.example.demo.models.Paint;
import com.example.demo.repositories.CocinaRepository;
import com.example.demo.repositories.PaintRepository;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.CocinaResponse;
import com.example.demo.response.PaintResponse;
import com.example.demo.response.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class CocinaService {
    @Autowired
    CocinaRepository cocinaRepository;

    public ArrayList<Cocina> obtenerCocina(){
        return (ArrayList<Cocina>) cocinaRepository.findAll();
    }
    public Optional<Cocina> obtenerId(Integer id){
        if(cocinaRepository.existsById(id)){
            return cocinaRepository.findById(id);
        }else{
            return Optional.empty();
        }
    }

    //Guardar consola
    public ResponseEntity<ResponseDTO> guardarCocina(RequestDTO requestDTO) {
        //Guardamos el objeto consola
        Cocina cocina = cocinaRepository.save(requestDTO.getRequest().getCocina());

        //Llenar una respuesta
        CocinaResponse cocinaResponse = new CocinaResponse();
        cocinaResponse.setUtencilio(cocina.getUtencilio());
        cocinaResponse.setDescripcion(cocina.getDescripcion());
        cocinaResponse.setEstado(cocina.getEstado());

        //Dar la respuesta
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Cocina agregada correctamente");
        responseDTO.setCocina(cocinaResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }
}
