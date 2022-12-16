package com.trips.tripsspringboot.repository;

import com.trips.tripsspringboot.entity.Terminal;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ITerminalRepository extends JpaRepository<Terminal, Long> {
    Terminal findTerminalByLocalidadAndDireccion(String localidad, String direccion);
}
