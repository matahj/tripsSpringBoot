package com.trips.tripsspringboot.service;

import com.trips.tripsspringboot.entity.Terminal;

import java.util.List;
import java.util.Optional;

public interface ITerminalService {
    List<Terminal> getAll();
    Optional<Terminal> getOneById(long idTerminal);
    public Terminal findOneByLocalidadAndDireccion(String localidad, String direccion);
    Terminal create(Terminal terminal);
    public void delete(long id);
    public Terminal update(long id, Terminal terminal);
}
