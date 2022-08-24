package com.example.mvcapp.informacionEmpresa;

public class Empleado {
    private String nombre;
    private int idEmpleado;
    private String correoElectronico;
    private String empresaEnQueTrabaja;
    private String rolDelEmpleado;


    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }

    public int getIdEmpleado() {
        return idEmpleado;
    }

    public void setIdEmpleado(int idEmpleado) {
        this.idEmpleado = idEmpleado;
    }

    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getEmpresaEnQueTrabaja() {
        return empresaEnQueTrabaja;
    }

    public void setEmpresaEnQueTrabaja(String empresaEnQueTrabaja) {
        this.empresaEnQueTrabaja = empresaEnQueTrabaja;
    }

    public String getRolDelEmpleado() {
        return rolDelEmpleado;
    }

    public void setRolDelEmpleado(String rolDelEmpleado) {
        this.rolDelEmpleado = rolDelEmpleado;
    }


}
