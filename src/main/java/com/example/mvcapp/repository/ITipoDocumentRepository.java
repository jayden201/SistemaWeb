package com.example.mvcapp.repository;

import com.example.mvcapp.informacionEmpresa.TipoDocumento;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;

@Repository
public interface ITipoDocumentRepository extends JpaRepository<TipoDocumento,Integer> {

    @Query("SELECT t FROM TipoDocumento t WHERE  t.nombre = ?1")  // se conoce en SQL como el alias mezcla SQL y java
    ArrayList<TipoDocumento> findByNombre(String nombre);


}
