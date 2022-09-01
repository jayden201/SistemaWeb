package com.example.mvcapp.services;

import com.example.mvcapp.informacionEmpresa.MovimientoDinero;
import com.example.mvcapp.repository.IMovimientoDineroRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MovimientoDineroService {
    private IMovimientoDineroRepository repository;

    public MovimientoDineroService(IMovimientoDineroRepository rep){
        this.repository = rep;
    }

    public ArrayList<MovimientoDinero> selectAll(){
        return (ArrayList<MovimientoDinero>) this.repository.findAll();
    }

    public Response createMovimiento(MovimientoDinero data){
        this.repository.save(data);
        Response response = new Response();
        response.setCode(200);
        response.setMessage("Movimiento Registrado");
        return response;

    }
}
