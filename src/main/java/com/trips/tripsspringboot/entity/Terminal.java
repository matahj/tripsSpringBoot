package com.trips.tripsspringboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "terminales")
public class Terminal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTerminal;

    @Column(name = "localidad", nullable = false, length = 45)
    private String localidad;
    private String direccion;

    public long getIdTerminal() {
        return idTerminal;
    }

    public void setIdTerminal(long idTerminal) {
        this.idTerminal = idTerminal;
    }

    public String getLocalidad() {
        return localidad;
    }

    public void setLocalidad(String localidad) {
        this.localidad = localidad;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
}
