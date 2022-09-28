package com.example.mvcapp.controllers;


import com.example.mvcapp.informacionEmpresa.Empleado;
import com.example.mvcapp.informacionEmpresa.Empresa;
import com.example.mvcapp.services.EmpleadoService;
import com.example.mvcapp.services.Response;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

//@RestController
@Controller

public class EmpleadoController {
    private EmpleadoService empleadoService;
    public EmpleadoController(EmpleadoService empleadoService){

        this.empleadoService = empleadoService;
    }
    @RequestMapping("user")
    public Response consultarEmpleado(){
        return this.empleadoService.getEmpleado();
    }
  /*  @PostMapping("user")
    public Response createEmpleado(@RequestBody Empleado request){
        return this.empleadoService.createEmpleado(request);
    }  */

    //Controlador para buscar Empresa ingresando su Id
    @RequestMapping("user/{id}")
    public Empleado ConsultarEmpleadoId(@PathVariable int id){
        return this.empleadoService.consultarEmpleadoById(id);
    }

    //COntrolador para eliminar Empleado Utilizando Id
    @DeleteMapping("user/{id}")
    public Response deleteEmpleado(@PathVariable int id){
        return this.empleadoService.deleteEmpleado(id);
    }

    //Controlador para actualizar datos que jala de EmpleadoSercice el metodo actualizarEmpleado
    @PutMapping("user")
    public Response actualizarEmpleado(@RequestBody Empleado empleado){
        return this.empleadoService.actualizarEmpleado(empleado);
    }


    @GetMapping("crearempleado")
    public String crearempleado(){
        return "empleado/crearempleado";
    }

    //controlador para insertar una empresa nueva.
    @PostMapping("empleado")
    public RedirectView createEmpleado(Empleado data){
        Response response = this.empleadoService.createEmpleado(data);
        return new RedirectView("crearempleado");
    }
   /* @GetMapping("/")
    public String root(){
        return "login";
    }
    @GetMapping("login")
    public String login(){
        return "login";
    }  */

}
