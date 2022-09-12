package com.example.mvcapp.services;


import com.example.mvcapp.informacionEmpresa.MovimientoDinero;
import com.example.mvcapp.repository.IMovimientoDineroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;

@Service
public class MovimientoDineroService {
    private IMovimientoDineroRepository repository;

    public MovimientoDineroService(IMovimientoDineroRepository rep){
        this.repository = rep;
    }

    public ArrayList<MovimientoDinero> selectAll(){
        return (ArrayList<MovimientoDinero>) this.repository.findAll();
    }

    public Response createMovimiento(int monto, String concepto, int empresa){
        this.repository.crearMovimientoId(monto,concepto,empresa);
        Response response = new Response();
        response.setCode(200);
        response.setMessage("Movimiento Registrado");
        return response;

    }

    public MovimientoDinero selectById(int Id){

        Optional<MovimientoDinero> existe = this.repository.findById(Id);
        if(existe.isPresent()){
            return existe.get();
        }
        else {
            return null;
        }
    }

    public Response deleteMovementIdEmpresa(int Id){
        Response response = new Response();
        try {
            this.repository.deleteMovimientoIdEmpresa(Id);
            response.setCode(200);
            response.setMessage("Movimiento Eliminado eliminado exitosamente");
            return response;
        }
        catch (Exception ex){
            response.setCode(500);
            response.setMessage("Error "+ ex.getMessage());
            return response;
        }
    }
    public Response updateMovement(int id, String concepto, int monto){

        this.repository.updateMovementId(concepto,monto,id);
        Response response = new Response();
        response.setCode(200);
        response.setMessage("Movimiento Modificado");
        return response;
    }
}
