package com.example.mvcapp.informacionEmpresa;

import javax.persistence.*;

@Entity
@Table(name = "movimientodinero")
public class MovimientoDinero {

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

    public MovimientoDinero(){
        super();
    }



    public MovimientoDinero(int monto,String concepto){
        this.monto = monto;
        this.concepto = concepto;

    }


    public int getId() {
        return id;
    }


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
}
