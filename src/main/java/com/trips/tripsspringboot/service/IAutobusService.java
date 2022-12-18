package com.trips.tripsspringboot.service;

import com.trips.tripsspringboot.entity.Autobus;

import java.util.List;
import java.util.Optional;

public interface IAutobusService {
    List<Autobus> getAll();
    Optional<Autobus> getOneById(long id);
    Autobus getAutobusByMatricula(String matricula);
    Autobus create(long id, Autobus autobus);
    Autobus upedate(long id, Autobus autobus);
    void delete(long id);
}
