package com.example.demo.services;

import com.example.demo.models.Paint;
import com.example.demo.repositories.PaintRepository;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.PaintResponse;
import com.example.demo.response.ResponseDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class PaintService
{
    @Autowired
    PaintRepository paintRepository;

    public ArrayList<Paint> obtenerPaints(){
        return (ArrayList<Paint>) paintRepository.findAll();
    }
    public Optional<Paint> obtenerId(Integer id){
    if(paintRepository.existsById(id)){
        return paintRepository.findById(id);
    }else{
        return Optional.empty();
    }
    }

    //Guardar consola
    public ResponseEntity<ResponseDTO> guardarPaint(RequestDTO requestDTO) {
        //Guardamos el objeto consola
        Paint paint = paintRepository.save(requestDTO.getRequest().getPaint());

        //Llenar una respuesta
        PaintResponse paintResponse = new PaintResponse();
        paintResponse.setColor(paint.getColor());
        paintResponse.setPrice(paint.getPrice());
        paintResponse.setDescription(paint.getDescription());
        paintResponse.setStatus(paint.getStatus());

        //Dar la respuesta
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Paint agregada correctamente");
        responseDTO.setPaint(paintResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //Actualizar Paint
    public ResponseEntity<ResponseDTO> actualizarPaint(RequestDTO requestDTO){
        paintRepository.updateColor(requestDTO.getRequest().getPaint().getColor(),
                requestDTO.getRequest().getPaint().getId());

        paintRepository.updatePrice(requestDTO.getRequest().getPaint().getPrice(),
                requestDTO.getRequest().getPaint().getId());

        paintRepository.updateDescription(requestDTO.getRequest().getPaint().getDescription(),
                requestDTO.getRequest().getPaint().getId());

        paintRepository.updateStatus(requestDTO.getRequest().getPaint().getStatus(),
                requestDTO.getRequest().getPaint().getId());

        //lenar una respuesta
        PaintResponse paintResponse = new PaintResponse();
        paintResponse.setColor(requestDTO.getRequest().getPaint().getColor());
        paintResponse.setPrice(requestDTO.getRequest().getPaint().getPrice());
        paintResponse.setDescription(requestDTO.getRequest().getPaint().getDescription());
        paintResponse.setStatus(requestDTO.getRequest().getPaint().getStatus());

        //Dar la respuesta
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Paint actualziada correctamente");
        responseDTO.setPaint(paintResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //Eliminar Paint
    public ResponseEntity<ResponseDTO>eliminarPaint (RequestDTO requestDTO){
        Integer id_consola = requestDTO.getRequest().getPaint().getId();
        PaintResponse paintResponse = new PaintResponse();
        ResponseDTO responseDTO = new ResponseDTO();
        paintResponse.setId(id_consola);
        if (paintRepository.existsById(id_consola)) {
            paintRepository.deleteById(id_consola);

            //Dar la respuesta

            responseDTO.setResponse("Paint eliminado correctamente");
            responseDTO.setPaint(paintResponse);

            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        }else {

            //Dar la respuesta
            responseDTO.setResponse("la consola con el id" + id_consola + " no existe");
            responseDTO.setPaint(paintResponse);

            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        }


    }
}
