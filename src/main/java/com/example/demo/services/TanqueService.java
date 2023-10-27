package com.example.demo.services;


import com.example.demo.models.Tanque;
import com.example.demo.repositories.TanqueRepository;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.ResponseDTO;
import com.example.demo.response.TanqueResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
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

    //Guardar Tanque
    public ResponseEntity<ResponseDTO> guardarTanque(RequestDTO requestDTO) {
        //Guardamos el objeto consola
        Tanque tanque = tanqueRepository.save(requestDTO.getRequest().getTanque());

        //Llenar una respuesta
        TanqueResponse tanqueResponse = new TanqueResponse();
        tanqueResponse.setCapacidad(tanque.getCapacidad());
        tanqueResponse.setNivel_actual(tanque.getNivel_actual());
        tanqueResponse.setTipo_gasolina(tanque.getTipo_gasolina());
        tanqueResponse.setUbicacion(tanque.getUbicacion());
        tanqueResponse.setPrecio_galon(tanque.getPrecio_galon());
        tanqueResponse.setId_Cliente(tanque.getId_Cliente());
        tanqueResponse.setTipo_pago(tanque.getTipo_pago());
        tanqueResponse.setFecha(tanque.getFecha());

        //Dar la respuesta
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Tanque agregada correctamente");
        responseDTO.setTanque(tanqueResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

}
