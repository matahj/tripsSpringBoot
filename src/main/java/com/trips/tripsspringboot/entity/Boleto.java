package com.trips.tripsspringboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "boletos")
public class Boleto {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idBoleto;
    @Column(name = "numeroAsiento", nullable = false)
    int numeroAsiento;

    @ManyToOne
    @JoinColumn(name = "clientes_idCliente", referencedColumnName = "idCliente", nullable = false)
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "viajes_idViaje", referencedColumnName = "idViaje", nullable = false)
    private Viaje viaje;

    public long getIdBoleto() {
        return idBoleto;
    }

    public void setIdBoleto(long idBoleto) {
        this.idBoleto = idBoleto;
    }

    public int getNumeroAsiento() {
        return numeroAsiento;
    }

    public void setNumeroAsiento(int numeroAsiento) {
        this.numeroAsiento = numeroAsiento;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Viaje getViaje() {
        return viaje;
    }

    public void setViaje(Viaje viaje) {
        this.viaje = viaje;
    }
}
