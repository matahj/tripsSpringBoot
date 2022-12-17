package com.trips.tripsspringboot.service;

import com.trips.tripsspringboot.entity.Terminal;

import java.util.List;
import java.util.Optional;

public interface ITerminalService {
    List<Terminal> getAll();
    Optional<Terminal> getOneById(long idTerminal);
    Terminal create(Terminal terminal);
}
