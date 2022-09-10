package com.example.mvcapp.repository;


import com.example.mvcapp.informacionEmpresa.MovimientoDinero;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.Optional;
@Repository
public interface IMovimientoDineroRepository extends JpaRepository<MovimientoDinero, Integer> {

    @Query("SELECT u from MovimientoDinero u where u.empresaid = ?1")
    Optional<MovimientoDinero> consultaMovimiento (int empresaid);

    @Query("INSERT INTO MovimientoDinero (monto,concepto,empresaid) VALUES (?1,?2,?3)" )
    Optional<MovimientoDinero> crearMovimientoId (int monto, String concepto, int empresaid);

    @Query("DELETE FROM MovimientoDinero WHERE empresaid=?1 " )
    Optional<MovimientoDinero> deleteMovimientoIdEmpresa (int empresaid);
}



