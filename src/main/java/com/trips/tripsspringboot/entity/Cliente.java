package com.trips.tripsspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
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

}
