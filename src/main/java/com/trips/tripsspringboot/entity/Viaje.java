package com.trips.tripsspringboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "viajes")
public class Viaje {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idViaje;
    @Column(name = "fechaSalida", nullable = false, length = 45)
    private String fechaSalida;
    @Column(name = "precio", nullable = false)
    private double precio;

    @ManyToOne
    @JoinColumn(name = "terminales_idOrigen", referencedColumnName = "idTerminal", nullable = false)
    private Terminal origen;

    @ManyToOne
    @JoinColumn(name = "terminales_idDestino", referencedColumnName = "idTerminal", nullable = false)
    private Terminal destino;

    @ManyToOne
    @JoinColumn(name = "conductores_idConductor", referencedColumnName = "idConductor", nullable = false)
    private Conductor conductor;

    @ManyToOne
    @JoinColumn(name = "autobuses_idAutobus", referencedColumnName = "idAutobus", nullable = false)
    private Autobus autobus;


    public long getIdViaje() {
        return idViaje;
    }

    public void setIdViaje(long idViaje) {
        this.idViaje = idViaje;
    }

    public String getFechaSalida() {
        return fechaSalida;
    }

    public void setFechaSalida(String fechaSalida) {
        this.fechaSalida = fechaSalida;
    }

    public double getPrecio() {
        return precio;
    }

    public void setPrecio(double precio) {
        this.precio = precio;
    }

    public Terminal getOrigen() {
        return origen;
    }

    public void setOrigen(Terminal origen) {
        this.origen = origen;
    }

    public Terminal getDestino() {
        return destino;
    }

    public void setDestino(Terminal destino) {
        this.destino = destino;
    }

    public Conductor getConductor() {
        return conductor;
    }

    public void setConductor(Conductor conductor) {
        this.conductor = conductor;
    }

    public Autobus getAutobus() {
        return autobus;
    }

    public void setAutobus(Autobus autobus) {
        this.autobus = autobus;
    }
}
