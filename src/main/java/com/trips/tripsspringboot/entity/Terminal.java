package com.trips.tripsspringboot.entity;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "terminales")
public class Terminal {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long idTerminal;

    @Column(name = "localidad", nullable = false, length = 45)
    private String localidad;

    @Column(name = "direccion", nullable = false, length = 45)
    private String direccion;
}
