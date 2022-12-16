package com.trips.tripsspringboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "autobuses")
public class Autobus {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idAutobus;
    @Column(name = "matricula", nullable = false, length = 45)
    private String matricula;
    @Column(name = "clase", nullable = false, length = 45)
    private String clase;
    @Column(name = "estadoMecanico", nullable = false, length = 45)
    private String estadoMecanico;
    @Column(name = "modelo", nullable = false, length = 45)
    private String modelo;

    @ManyToOne
    @JoinColumn(name = "terminales_idTerminal", referencedColumnName = "idTerminal", nullable = false)
    private Terminal terminal;

    public long getIdAutobus() {
        return idAutobus;
    }

    public void setIdAutobus(long idAutobus) {
        this.idAutobus = idAutobus;
    }

    public String getMatricula() {
        return matricula;
    }

    public void setMatricula(String matricula) {
        this.matricula = matricula;
    }

    public String getClase() {
        return clase;
    }

    public void setClase(String clase) {
        this.clase = clase;
    }

    public String getEstadoMecanico() {
        return estadoMecanico;
    }

    public void setEstadoMecanico(String estadoMecanico) {
        this.estadoMecanico = estadoMecanico;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public Terminal getTerminal() {
        return terminal;
    }

    public void setTerminal(Terminal terminal) {
        this.terminal = terminal;
    }
}
