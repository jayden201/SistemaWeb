package com.example.mvcapp;

//import com.example.mvcapp.informacionEmpresa.Empleado;
//import com.example.mvcapp.informacionEmpresa.MovimientoDinero;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class MvcappApplication {

	public static void main(String[] args) {

		SpringApplication.run(MvcappApplication.class, args);

		/*

		MovimientoDinero monto = new MovimientoDinero();
		monto.setNombre("Luis");

		monto.MovimientoDinero(1000,"abono");
		System.out.println(monto.getMonto()+monto.getConcepto()+monto.getNombre()+monto.getNombre());*/

	}

}
