package com.trips.tripsspringboot.service;

import com.trips.tripsspringboot.entity.Cliente;

import java.util.List;
import java.util.Optional;

public interface IClienteService {

    List<Cliente> getAll();

    Optional<Cliente> getOneById(long id);

    Cliente getOneByEmail(String email);

    Cliente create(Cliente cliente);

    Cliente update(long id, Cliente cliente);

    void delete(long id);
}
