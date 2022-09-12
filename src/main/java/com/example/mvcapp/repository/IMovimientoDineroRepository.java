package com.example.mvcapp.repository;


import com.example.mvcapp.informacionEmpresa.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Optional;
@Repository
public interface IMovimientoDineroRepository extends JpaRepository<MovimientoDinero, Integer> {

    @Query(value = "SELECT u from MovimientoDinero u where u.empresaid = ?1",nativeQuery = true)
    ArrayList<MovimientoDinero> consultaMovimiento (int empresaid);
    @Modifying
    @Query(value = "INSERT INTO MovimientoDinero (monto,concepto,empresaid) VALUES (:monto,:concepto,:empresaid)" ,nativeQuery = true)
    @Transactional
    void crearMovimientoId (int monto, String concepto, int empresaid);

    @Modifying
    @Query(value = "DELETE FROM MovimientoDinero WHERE empresaid=?1 ",nativeQuery = true)
    @Transactional
    void deleteMovimientoIdEmpresa (int empresaid);

    @Modifying
    @Query("UPDATE MovimientoDinero m set m.concepto = :concepto, m.monto= :monto WHERE empresaid = :empresaid")
    @Transactional
    void updateMovementId(String concepto, int monto,int empresaid);
}



