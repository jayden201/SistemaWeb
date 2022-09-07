package com.example.mvcapp.controllers;


import com.example.mvcapp.informacionEmpresa.Empresa;
import com.example.mvcapp.services.EmpresaService;
import com.example.mvcapp.services.Response;
import org.springframework.web.bind.annotation.*;

//indico que esta clase funciona como controlador
@RestController
public class EmpresaController {

    //Agrego propiedad de tipo EmpresaService llamada empresa service para poder trabajar con la logica de negocio
    private EmpresaService empresaService;

    //Metodo COntructor que recibe como parametro el objeto EmpresaService y le pongo como nombre empresaService
    //para poder traer todos los metodos de la clase EmpresaService
    public EmpresaController(EmpresaService empresaService){
        this.empresaService = empresaService;
    }

    @RequestMapping("users")
    public Response consultarEmpresa(){
        return this.empresaService.getEmpresa();
    }

    //controlador para insertar una empresa nueva.
    @PostMapping("users")
    public Response createEmpresa(@RequestBody Empresa request){
        return this.empresaService.createEmpresa(request);
    }

    //Controlador para buscar Empresa ingresando su Id
    @RequestMapping("users/{id}")
    public Empresa ConsultarEmpresaId(@PathVariable int id){
        return this.empresaService.consultarEmpresaById(id);
    }

    //COntrolador para eliminar Empresa Utilizando Id
    @DeleteMapping("users/{id}")
    public Response deleteEmpresa(@PathVariable int id){
        return this.empresaService.deleteEmpresa(id);
    }

    //Controlador para actualizar datos que jala de EmpresaSercice el metodo actualizarEmpresa
    @PutMapping("users")
    public Response actualizarEmpresa(@RequestBody Empresa empresa){
        return this.empresaService.actualizarEmpresa(empresa);
    }


}
