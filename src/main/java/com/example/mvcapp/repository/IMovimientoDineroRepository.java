package com.example.mvcapp.repository;

import com.example.mvcapp.informacionEmpresa.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IMovimientoDineroRepository extends JpaRepository<MovimientoDinero, Integer> {
}
