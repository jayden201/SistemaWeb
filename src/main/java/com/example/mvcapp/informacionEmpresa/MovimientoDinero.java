package com.example.mvcapp.informacionEmpresa;

import javax.persistence.*;

@Entity
@Table(name = "Movimiento")
public class MovimientoDinero extends Empleado{

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    @Column(name = "monto")
    private int monto;
    @Column(name = "concepto")
    private String concepto;


    @ManyToOne
    @JoinColumn(name = "empresaid",insertable = false,updatable = false)
    private Empresa empresa;

    @ManyToOne
    @JoinColumn(name = "empleadoid", insertable = false,updatable = false)
    private Empleado empleado;

    public MovimientoDinero(){
        super();
    }



    public MovimientoDinero(int monto,String concepto){
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

    public void setConcepto(String concepto) {
        this.concepto = concepto;
    }



    public Empresa getEmpresa() {
        return empresa;
    }

    public void setEmpresa(Empresa empresa) {
        this.empresa = empresa;
    }

    public Empleado getEmpleado() {
        return empleado;
    }

    public void setEmpleado(Empleado empleado) {
        this.empleado = empleado;
    }
}
