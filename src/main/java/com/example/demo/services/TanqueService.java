package com.example.demo.services;


import com.example.demo.models.Tanque;
import com.example.demo.repositories.TanqueRepository;
import com.example.demo.request.RequestDTO;
import com.example.demo.response.PaintResponse;
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
    public TanqueRepository tanqueRepository;

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
    public Optional<Double> obtenerNivelActualPorId(Integer id) {
        if (tanqueRepository.existsById(id)) {
            Optional<Tanque> tanqueOptional = tanqueRepository.findById(id);
            if (tanqueOptional.isPresent()) {
                return Optional.of(tanqueOptional.get().getNivel_actual());
            } else {
                return Optional.empty();
            }
        } else {
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

    //Actualizar Tanque
    public ResponseEntity<ResponseDTO> actualizarTanque(RequestDTO requestDTO){
        tanqueRepository.updateCapacidad(requestDTO.getRequest().getTanque().getCapacidad(),
                requestDTO.getRequest().getTanque().getId());

        tanqueRepository.updateNivel(requestDTO.getRequest().getTanque().getNivel_actual(),
                requestDTO.getRequest().getTanque().getId());

        tanqueRepository.updateTipoGasolina(requestDTO.getRequest().getTanque().getTipo_gasolina(),
                requestDTO.getRequest().getTanque().getId());

        tanqueRepository.updateUbicacion(requestDTO.getRequest().getTanque().getUbicacion(),
                requestDTO.getRequest().getTanque().getId());

        tanqueRepository.updatePrecio(requestDTO.getRequest().getTanque().getPrecio_galon(),
                requestDTO.getRequest().getTanque().getId());

        tanqueRepository.updateCliente(requestDTO.getRequest().getTanque().getId_Cliente(),
                requestDTO.getRequest().getTanque().getId());

        tanqueRepository.updateTipoPago(requestDTO.getRequest().getTanque().getTipo_pago(),
                requestDTO.getRequest().getTanque().getId());

        tanqueRepository.updateFecha(requestDTO.getRequest().getTanque().getFecha(),
                requestDTO.getRequest().getTanque().getId());

        //lenar una respuesta
        TanqueResponse tanqueResponse = new TanqueResponse();
        tanqueResponse.setCapacidad(requestDTO.getRequest().getTanque().getCapacidad());
        tanqueResponse.setNivel_actual(requestDTO.getRequest().getTanque().getNivel_actual());
        tanqueResponse.setTipo_gasolina(requestDTO.getRequest().getTanque().getTipo_gasolina());
        tanqueResponse.setUbicacion(requestDTO.getRequest().getTanque().getUbicacion());
        tanqueResponse.setPrecio_galon(requestDTO.getRequest().getTanque().getPrecio_galon());
        tanqueResponse.setId_Cliente(requestDTO.getRequest().getTanque().getId_Cliente());
        tanqueResponse.setTipo_pago(requestDTO.getRequest().getTanque().getTipo_pago());
        tanqueResponse.setFecha(requestDTO.getRequest().getTanque().getFecha());

        //Dar la respuesta
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Tanque actualziada correctamente");
        responseDTO.setTanque(tanqueResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }

    //Actualizar Nivel
    public ResponseEntity<ResponseDTO> actualizarNivelTanque(RequestDTO requestDTO){
        System.out.println(requestDTO.getRequest().getTanque().getNivel_actual());
        System.out.println(requestDTO.getRequest().getTanque().getId());
        tanqueRepository.updateNivel(requestDTO.getRequest().getTanque().getNivel_actual(),
                requestDTO.getRequest().getTanque().getId());

        //lenar una respuesta
        TanqueResponse tanqueResponse = new TanqueResponse();
        tanqueResponse.setNivel_actual(requestDTO.getRequest().getTanque().getNivel_actual());

        //Dar la respuesta
        ResponseDTO responseDTO = new ResponseDTO();
        responseDTO.setResponse("Nivel de Tanque actualziada correctamente");
        responseDTO.setTanque(tanqueResponse);

        return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
    }


    //Eliminar Tanque
    public ResponseEntity<ResponseDTO>eliminarTanque (RequestDTO requestDTO){
        Integer id_tanque = requestDTO.getRequest().getTanque().getId();
        TanqueResponse tanqueResponse = new TanqueResponse();
        ResponseDTO responseDTO = new ResponseDTO();
        tanqueResponse.setId(id_tanque);
        if (tanqueRepository.existsById(id_tanque)) {
            tanqueRepository.deleteById(id_tanque);

            //Dar la respuesta

            responseDTO.setResponse("Tanque eliminado correctamente");
            responseDTO.setTanque(tanqueResponse);

            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        }else {

            //Dar la respuesta
            responseDTO.setResponse("El Tanque con el id" + id_tanque + " no existe");
            responseDTO.setTanque(tanqueResponse);

            return new ResponseEntity<ResponseDTO>(responseDTO, HttpStatus.OK);
        }

    }

}
