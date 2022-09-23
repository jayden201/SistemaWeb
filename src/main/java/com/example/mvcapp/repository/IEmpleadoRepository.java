package com.example.mvcapp.repository;

import com.example.mvcapp.informacionEmpresa.Empleado;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IEmpleadoRepository extends JpaRepository<Empleado,Integer> {


}
