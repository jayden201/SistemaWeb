package com.example.mvcapp.repository;

import com.example.mvcapp.informacionEmpresa.Empresa;
import org.springframework.data.jpa.repository.JpaRepository;

public interface IEmpresaRepository extends JpaRepository<Empresa,Integer> {


}
