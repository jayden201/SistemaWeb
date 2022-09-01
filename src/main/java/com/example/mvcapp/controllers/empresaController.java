package com.example.mvcapp.controllers;


import com.example.mvcapp.informacionEmpresa.Empresa;
import com.example.mvcapp.services.EmpresaService;
import com.example.mvcapp.services.Response;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
//indico que esta clase funciona como controlador
@RestController
public class empresaController {

    //Agrego propiedad de tipo EmpresaService llamada empresa service para poder trabajar con la logica de negocio
    private EmpresaService empresaService;

    //Metodo COntructor que recibe como parametro el objeto EmpresaService y le pongo como nombre empresaService
    //para poder traer todos los metodos de la clase EmpresaService
    public empresaController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }

    @RequestMapping("enterprises")
    public Response consultarEmpresa(){
        return this.empresaService.getEmpresa();
    }

    @PostMapping("enterprises")
    public Response createEmpresa(@RequestBody Empresa request){
        return this.empresaService.createEmpresa(request);
    }


}
