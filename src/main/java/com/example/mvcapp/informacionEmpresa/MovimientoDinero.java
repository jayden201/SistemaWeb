package com.example.mvcapp.informacionEmpresa;

import javax.persistence.*;

@Entity
@Table(name = "Empresa")
public class MovimientoDinero extends Empleado{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "monto")
    private int monto;
    @Column(name = "concepto")
    private String concepto;
    @Column(name = "empleado")
    private String empleado;

    public MovimientoDinero(){
        super();
    }

    public MovimientoDinero(int monto,String concepto){
        this.empleado = super.getNombre();
        this.monto = monto;
        this.concepto = concepto;

    }

    @Override
    public int getId() {
        return id;
    }

    @Override
    public void setId(int id) {
        this.id = id;
    }

    public int getMonto() {
        return monto;
    }

    public void setMonto(int monto) {
        this.monto = monto;
    }

    public String getConcepto() {
        return concepto;
    }

    public void setDescripcion(String descripcion) {
        this.concepto = descripcion;
    }


    public String getEmpleado() {
        return empleado;
    }

    public void setEmpleado(String empleado) {
        this.empleado = empleado;
    }
}
