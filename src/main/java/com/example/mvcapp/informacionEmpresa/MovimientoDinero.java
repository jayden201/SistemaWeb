package com.example.mvcapp.informacionEmpresa;

public class MovimientoDinero {

    private int monto;
    private String concepto;
    private String usuario;

    public void MovimientoDinero(int monto,String descripcion,String usuario){
        this.monto = monto;
        this.concepto = descripcion;
        this.setUsuario(usuario);
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

    public String getUsuario() {
        return usuario;
    }

    public void setUsuario(String usuario) {
        this.usuario = usuario;
    }
}
