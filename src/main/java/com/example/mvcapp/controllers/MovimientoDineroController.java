package com.example.mvcapp.controllers;

import com.example.mvcapp.dto.movimientoDTO;
import com.example.mvcapp.informacionEmpresa.Empleado;
import com.example.mvcapp.informacionEmpresa.Empresa;
import com.example.mvcapp.informacionEmpresa.MovimientoDinero;
import com.example.mvcapp.repository.IMovimientoDineroRepository;
import com.example.mvcapp.services.EmpleadoService;
import com.example.mvcapp.services.EmpresaService;
import com.example.mvcapp.services.MovimientoDineroService;
import com.example.mvcapp.services.Response;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.view.RedirectView;

import java.util.ArrayList;

//@RestController
@Controller

public class MovimientoDineroController {

    private MovimientoDineroService service;
    private EmpleadoService empleadoService;

    private  EmpresaService empresaService;

    public MovimientoDineroController(MovimientoDineroService ser, EmpleadoService emp, EmpresaService em){

        this.service = ser;
        this.empleadoService = emp;
        this.empresaService = em;
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

    @GetMapping ("/enterprises/crearmovimiento")
    public String createMovement(Model data){
        ArrayList<Empleado> empleados = empleadoService.selectAll();
        ArrayList<Empresa> empresas = empresaService.selectAll();
        data.addAttribute("empleados",empleados);
        data.addAttribute("empresas",empresas);
        return "movimiento/crearmovimiento";
    }

    @PostMapping("/enterprises/registermovement")
    public RedirectView registerMovement(movimientoDTO data){


        Response response = this.service.createMovimiento(data.getEmpleadoid().getId(), data.getMonto(), data.getConcepto(), data.getEmpresaid().getId());
        if(response.getCode() == 200){
            return new RedirectView("/enterprises/crearmovimiento");
        }
        else{
            return new RedirectView("/enterprises/crearmovimiento");
        }
    }

    @GetMapping ("consultamovimientos")
    public String consultamovimientos(){
        return "movimiento/movimientosregistrados";
    }


    @GetMapping("movimientos")
    public String movimientosregistrados(Model movimientos){
        ArrayList<MovimientoDinero> movimientosDB = this.getMovements();
        return "/useradmin/usuariosregistrados";
    }
    }


