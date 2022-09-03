package com.example.mvcapp.services;

import com.example.mvcapp.informacionEmpresa.Empresa;
import com.example.mvcapp.repository.IEmpresaRepository;
import org.springframework.stereotype.Service;

import java.util.Optional;


@Service
public class EmpresaService {
    //crea atributo para esta clase instanciadp de la clase IEmpresaRepository y le pongo nombre empresaRepository
    private IEmpresaRepository empresaRepository;

    //Crea metodo Constructor de esta clase
    public EmpresaService(IEmpresaRepository empresaRepository){
        this.empresaRepository = empresaRepository;
    }

    //Metodo para realizar peticion (GET) a la empresa en la logica servicio
    public Response getEmpresa(){
        Response response = new Response();
        this.empresaRepository.findAll();
        response.setCode(200);
        response.setMessage("datos Obtenidos correctamente");
        return response;
    }


    //Metodo para realizar insercion (Post) a la empresa
    public Response createEmpresa(Empresa empresa){
        Response response = new Response();
        this.empresaRepository.save(empresa);
        response.setCode(200);
        response.setMessage("Empresa Registrada correctamente");
        return response;
    }


    //Metodo para realizar consulta (GET) con la ruta enterprise/{id}
    public Empresa consultarEmpresaById(int Id){
        Optional<Empresa> existe = this.empresaRepository.findById(Id);
        if(existe.isPresent()){
            return existe.get();
        }
        else {
            return null;
        }
    }

    //Metodo servicio para eliminar una empresa ingresando un Id
    public Response deleteEmpresa(int Id){
        Response response = new Response();
        try{
            this.empresaRepository.deleteById(Id);
            response.setCode(200);
            response.setMessage("Empresa con Id: " + Id + " Fue eliminada correctamente");
            return response;
        }catch (Exception ex){
            response.setCode(500);
            response.setMessage("Error Id: "+Id+" No existe");
            return response;
        }
    }

}
