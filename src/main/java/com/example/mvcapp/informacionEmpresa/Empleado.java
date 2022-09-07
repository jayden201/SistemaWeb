package com.example.mvcapp.informacionEmpresa;

import javax.persistence.*;

@Entity
@Table(name = "Empleado")
public class Empleado {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @Column(name = "nombre")
    private String nombre;
    @Column(name = "correoElectronico")
    private String correoElectronico;
    @ManyToOne
    @JoinColumn(name = "empresaid")
    private Empresa empresaid;
    // private Empresa empresaEnQueTrabaja;
    @Column(name = "rolDelEmpleado")
    private String rolDelEmpleado;


    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }
    public String getNombre() {
        return nombre;
    }

    public void setNombre(String nombre) {
        this.nombre = nombre;
    }



    public String getCorreoElectronico() {
        return correoElectronico;
    }

    public void setCorreoElectronico(String correoElectronico) {
        this.correoElectronico = correoElectronico;
    }

    public String getRolDelEmpleado() {
        return rolDelEmpleado;
    }

    public void setRolDelEmpleado(String rolDelEmpleado) {
        this.rolDelEmpleado = rolDelEmpleado;
    }

    public Empresa getEmpresaid() {
        return empresaid;
    }

    public void setEmpresaid(Empresa empresaid) {
        this.empresaid = empresaid;
    }
}
