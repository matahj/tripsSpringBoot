package com.trips.tripsspringboot.entity;

import jakarta.persistence.*;

@Entity
@Table(name = "clientes")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idCliente;

    @Column(name = "nombreCompletoCl", nullable = false, length = 45)
    private String nombreCompletoCl;

    @Column(name = "email", nullable = false, length = 45)
    private String email;

    @Column(name = "telefono", nullable = true, length = 45)
    private String telefono;

    public long getIdCliente() {
        return idCliente;
    }

    public void setIdCliente(long idCliente) {
        this.idCliente = idCliente;
    }

    public String getNombreCompletoCl() {
        return nombreCompletoCl;
    }

    public void setNombreCompletoCl(String nombreCompletoCl) {
        this.nombreCompletoCl = nombreCompletoCl;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getTelefono() {
        return telefono;
    }

    public void setTelefono(String telefono) {
        this.telefono = telefono;
    }
}
