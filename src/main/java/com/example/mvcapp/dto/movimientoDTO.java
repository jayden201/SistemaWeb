package com.example.mvcapp.dto;

import com.example.mvcapp.informacionEmpresa.Empleado;
import com.example.mvcapp.informacionEmpresa.Empresa;

public class movimientoDTO {

    private int monto;
    private String concepto;
    private Empresa empresaid;
    private Empleado empleadoid;


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

    public Empresa getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(Empresa empresaid) {
        this.empresaid = empresaid;
    }

    public Empleado getEmpleadoid() {
        return empleadoid;
    }

    public void setEmpleadoid(Empleado empleadoid) {
        this.empleadoid = empleadoid;
    }
}
