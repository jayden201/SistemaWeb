package com.example.mvcapp.controllers;

import com.example.mvcapp.informacionEmpresa.MovimientoDinero;
import com.example.mvcapp.services.MovimientoDineroService;
import com.example.mvcapp.services.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

//@RestController
@Controller

public class MovimientoDineroController {

    private MovimientoDineroService service;

    public MovimientoDineroController(MovimientoDineroService ser){
        this.service = ser;
    }

    @RequestMapping("/enterprises/{id}/movements")
    public MovimientoDinero getMovementsByIdEmpresa(@PathVariable int id){

            return this.service.selectById(id);
        }
    @PostMapping("/enterprises/{id}/movements")
    public Response createMovement(@RequestBody MovimientoDinero request,@PathVariable int id){
        return this.service.createMovimiento(request.getEmpleado().getId(),request.getMonto(),request.getConcepto(),id);
    }

    @DeleteMapping("/enterprises/{id}/movements")
    public Response deleteMovement(@PathVariable int id){
        return this.service.deleteMovementIdEmpresa(id);
    }

    @PatchMapping("/enterprises/{id}/movements")
    public Response updateMovement(@RequestBody MovimientoDinero request, @PathVariable int id){
        return this.service.updateMovement(id, request.getConcepto(), request.getMonto());
    }
    @RequestMapping("/enterprises/allmovements")
    public ArrayList<MovimientoDinero> getMovements(){
        return null;
       // return this.service.selectAll();
    }

    @RequestMapping("create1")
    public String create(){
        return "empresa/create";
    }






    }


