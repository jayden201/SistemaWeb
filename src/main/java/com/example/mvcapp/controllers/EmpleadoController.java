package com.example.mvcapp.controllers;


import com.example.mvcapp.informacionEmpresa.Empleado;
import com.example.mvcapp.services.EmpleadoService;
import com.example.mvcapp.services.Response;
import org.springframework.web.bind.annotation.*;

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
@PostMapping("enterprises")
public Response createEmpleado(@RequestBody Empleado request){
    return this.empleadoService.createEmpleado(request);
}

    //Controlador para buscar Empresa ingresando su Id
    @RequestMapping("enterprises/{id}")
    public Empleado ConsultarEmpleadoId(@PathVariable int id){
        return this.empleadoService.consultarEmpleadoById(id);
    }

    //COntrolador para eliminar Empleado Utilizando Id
    @DeleteMapping("enterprises/{id}")
    public Response deleteEmpleado(@PathVariable int id){
        return this.empleadoService.deleteEmpleado(id);
    }

    //Controlador para actualizar datos que jala de EmpleadoSercice el metodo actualizarEmpleado
    @PutMapping("enterprises")
    public Response actualizarEmpleado(@RequestBody Empleado empleado){
        return this.empleadoService.actualizarEmpleado(empleado);
    }

}
