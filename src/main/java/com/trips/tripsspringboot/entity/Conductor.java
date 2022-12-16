package com.trips.tripsspringboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "conductores")
public class Conductor {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idConductor;
    @Column(name = "nombreCompletoCo", nullable = false, length = 45)
    private String nombreCompletoCo;
    @Column(name = "telefono", nullable = true, length = 45)
    private String telefono;
    @Column(name = "domicilio", nullable = false, length = 45)
    private String domicilio;

    @ManyToOne
    @JoinColumn(name = "terminales_idTerminal", referencedColumnName = "idTerminal", nullable = false)
    private Terminal terminal;

    public long getIdConductor() {
        return idConductor;
    }

    public void setIdConductor(long idConductor) {
        this.idConductor = idConductor;
    }

    public String getNombreCompletoCo() {
        return nombreCompletoCo;
    }

    public void setNombreCompletoCo(String nombreCompletoCo) {
        this.nombreCompletoCo = nombreCompletoCo;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }

    public String getDomicilio() {
        return domicilio;
    }

    public void setDomicilio(String domicilio) {
        this.domicilio = domicilio;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }
}
