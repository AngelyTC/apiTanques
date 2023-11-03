package com.example.demo.services;

import com.example.demo.models.Nombre;
import com.example.demo.models.Paint;
import com.example.demo.repositories.NombreRepository;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.NombreResponse;
import com.example.demo.response.PaintResponse;
import com.example.demo.response.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class NombreService {

    @Autowired
    NombreRepository nombreRepository;

    public ArrayList<Nombre> obtenerNombre(){
        return (ArrayList<Nombre>) nombreRepository.findAll();
    }
    public Optional<Nombre> obtenerId(Integer id){
        if(nombreRepository.existsById(id)){
            return nombreRepository.findById(id);
        }else{
            return Optional.empty();
        }
    }

    //Guardar Nombre
    public ResponseEntity<ResponseDTO> guardarNombre(RequestDTO requestDTO) {
        //Guardamos el objeto consola
        Nombre nombre = nombreRepository.save(requestDTO.getRequest().getNombre());

        //Llenar una respuesta
        NombreResponse nombreResponse = new NombreResponse();
        nombreResponse.setNombre(nombre.getNombre());
        nombreResponse.setApellido(nombre.getApellido());

        //Dar la respuesta
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Nombre agregado correctamente");
        responseDTO.setNombre(nombreResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //Actualizar Nombre
    public ResponseEntity<ResponseDTO> actualizarNombre(RequestDTO requestDTO){
        nombreRepository.updateNombre(requestDTO.getRequest().getNombre().getNombre(),
                requestDTO.getRequest().getNombre().getId());

        nombreRepository.updateApellido(requestDTO.getRequest().getNombre().getApellido(),
                requestDTO.getRequest().getNombre().getId());

        //lenar una respuesta
        NombreResponse nombreResponse = new NombreResponse();
        nombreResponse.setNombre(requestDTO.getRequest().getNombre().getNombre());
        nombreResponse.setApellido(requestDTO.getRequest().getNombre().getApellido());

        //Dar la respuesta
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Nombre actualziada correctamente");
        responseDTO.setNombre(nombreResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //Eliminar Nombre
    public ResponseEntity<ResponseDTO>eliminarNombre (RequestDTO requestDTO){
        Integer id_nombre = requestDTO.getRequest().getNombre().getId();
        NombreResponse nombreResponse = new NombreResponse();
        ResponseDTO responseDTO = new ResponseDTO();
        nombreResponse.setId(id_nombre);
        if (nombreRepository.existsById(id_nombre)) {
            nombreRepository.deleteById(id_nombre);

            //Dar la respuesta

            responseDTO.setResponse("Nombre eliminado correctamente");
            responseDTO.setNombre(nombreResponse);

            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        }else {

            //Dar la respuesta
            responseDTO.setResponse("la consola con el id" + id_nombre + " no existe");
            responseDTO.setNombre(nombreResponse);

            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        }

    }
}
