package com.example.mvcapp.informacionEmpresa;

public class MovimientoDinero extends Empleado{

    private int monto;
    private String concepto;

    private String empleado;

    public MovimientoDinero(){
        super();
    }

    public MovimientoDinero(int monto,String concepto){
        this.empleado = super.getNombre();
        this.monto = monto;
        this.concepto = concepto;

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
