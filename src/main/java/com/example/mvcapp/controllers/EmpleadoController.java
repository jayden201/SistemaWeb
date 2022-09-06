package com.example.mvcapp.controllers;


import com.example.mvcapp.informacionEmpresa.Empleado;
import com.example.mvcapp.services.EmpleadoService;
import com.example.mvcapp.services.EmpresaService;
import com.example.mvcapp.services.Response;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController

public class EmpleadoController {
    private EmpleadoService empleadoService;
    public EmpleadoController(EmpleadoService empleadoService){
        this.empleadoService = empleadoService;
    }
    @RequestMapping("enterprises")
    public Response consultarEmpleado(){
        return this.empleadoService.getEmpleado();
    }


}
