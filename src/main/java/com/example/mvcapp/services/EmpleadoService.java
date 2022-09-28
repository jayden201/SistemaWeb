package com.example.mvcapp.services;

import com.example.mvcapp.informacionEmpresa.Empleado;
import com.example.mvcapp.repository.IEmpleadoRepository;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Optional;
@Service
public class EmpleadoService {
    private IEmpleadoRepository empleadoRepository;

    public EmpleadoService(IEmpleadoRepository empleadoRepository){
        this.empleadoRepository = empleadoRepository;
    }

    public ArrayList<Empleado> selectAll(){
        return (ArrayList<Empleado>) this.empleadoRepository.findAll();
    }
    //Metodo para realizar peticion (GET) al empleado en la logica servicio
    public Response getEmpleado(){
        Response response = new Response();
        this.empleadoRepository.findAll();
        response.setCode(200);
        response.setMessage("datos Obtenidos correctamente");
        return response;
    }
    public Response createEmpleado(Empleado empleado){
        Response response = new Response();
        this.empleadoRepository.save(empleado);
        response.setCode(200);
        response.setMessage("Empleado Registrada correctamente");
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
        existe.setCorreoElectronico(empleado.getCorreoElectronico());
        existe.setRolDelEmpleado(empleado.getRolDelEmpleado());
        existe.setEmpresaid(empleado.getEmpresaid());


        this.empleadoRepository.save(existe);
        response.setCode(200);
        response.setMessage("Empleado modificada correctamente");
        return response;

    }
    public Empleado selectByUserName(String username){
        Empleado existe = this.empleadoRepository.finByUserName(username);
        return existe;
    }

    public Response loginEmpleado(String correo){
        Response response = new Response();
        ArrayList<Empleado> existe = this.empleadoRepository.validaCredenciales(correo);

        //Validamos password
        if(existe != null && existe.size() > 0){
            response.setCode(200);
            response.setMessage("Usuario autenticado exitosamente.");
            return  response;
        }
        else{
            response.setCode(500);
            response.setMessage("Usuario  no autenticado exitosamente.");
            return  response;
        }




    }
}
