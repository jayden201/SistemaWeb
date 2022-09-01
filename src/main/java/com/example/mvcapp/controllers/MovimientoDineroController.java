package com.example.mvcapp.controllers;

import com.example.mvcapp.services.MovimientoDineroService;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class MovimientoDineroController {

    private MovimientoDineroService service;

    public MovimientoDineroController(MovimientoDineroService ser){
        this.service = ser;
    }


}
