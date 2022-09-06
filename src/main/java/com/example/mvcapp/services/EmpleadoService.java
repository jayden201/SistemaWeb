package com.example.mvcapp.services;

import com.example.mvcapp.informacionEmpresa.Empleado;
import com.example.mvcapp.informacionEmpresa.Empresa;
import com.example.mvcapp.repository.IEmpleadoRepository;

import java.util.Optional;

public class EmpleadoService {
    private IEmpleadoRepository empleadoRepository;

    public EmpleadoService(IEmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    //Metodo para realizar peticion (GET) al empleado en la logica servicio
    public Response getEmpleado(){
        Response response = new Response();
        this.empleadoRepository.findAll();
        response.setCode(200);
        response.setMessage("datos Obtenidos correctamente");
        return response;
    }
    //Metodo para realizar consulta (GET) con la ruta enterprise/{id}
    public Empleado consultarEmpleadoById(int Id){
        Optional<Empleado> existe = this.empleadoRepository.findById(Id);
        if(existe.isPresent()){
            return existe.get();
        }
        else {
            return null;
        }
    }
    // Metodo para eliminar una empresa con un id
    public Response deleteEmpleado(int Id){
        Response response = new Response();
        try{
            this.empleadoRepository.deleteById(Id);
            response.setCode(200);
            response.setMessage("Empleado con Id: " + Id + " Fue eliminada correctamente");
            return response;
        }catch (Exception ex){
            response.setCode(500);
            response.setMessage("Error Id: "+Id+" No existe");
            return response;
        }
    }
    //metodo para actualizar una empleado
    public Response actualizarEmpleado(Empleado empleado){
        Response response = new Response();

        if(empleado.getId() <= 0){
            response.setCode(500);
            response.setMessage("Error id no existe");
            return response;
        }

        Empleado existe = consultarEmpleadoById(empleado.getId());
        if(existe == null){
            response.setCode(500);
            response.setMessage("Error el usuario no existe en la base de datos");
            return response;
        }


        //Actualiza los datos de cada atributo ingresado
        existe.setNombre(empleado.getNombre());
        existe.setIdEmpleado(empleado.getIdEmpleado());
        existe.setCorreoElectronico(empleado.getCorreoElectronico());
        existe.setRolDelEmpleado(empleado.getRolDelEmpleado());

        this.empleadoRepository.save(existe);
        response.setCode(200);
        response.setMessage("Empleado modificada correctamente");
        return response;

    }
}
