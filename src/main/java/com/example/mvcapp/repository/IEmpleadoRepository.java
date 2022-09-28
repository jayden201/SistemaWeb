package com.example.mvcapp.repository;

import com.example.mvcapp.informacionEmpresa.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado,Integer> {
    @Query("SELECT u FROM User u WHERE u.correoElectronico = ?1")
    Empleado finByUserName(String correoElectronico);

    @Query("SELECT u FROM Empleado u WHERE u.correoElectronico = ?1")
    ArrayList<Empleado> validaCredenciales(String username);

}
