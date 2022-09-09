package com.example.mvcapp.controllers;

import com.example.mvcapp.informacionEmpresa.MovimientoDinero;
import com.example.mvcapp.services.MovimientoDineroService;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.ArrayList;

@RestController

public class MovimientoDineroController {

    private MovimientoDineroService service;

    public MovimientoDineroController(MovimientoDineroService ser){
        this.service = ser;
    }

    @RequestMapping("/enterprise/{id}/movements")
    public MovimientoDinero getMovementsByIdEmpresa(@PathVariable int id){

            return this.service.selectById(id);
        }
    }

