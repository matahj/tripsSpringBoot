package com.trips.tripsspringboot.service.impl;

import com.trips.tripsspringboot.entity.Cliente;
import com.trips.tripsspringboot.repository.IClienteRepository;
import com.trips.tripsspringboot.service.IClienteService;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements IClienteService {

    private IClienteRepository clienteRepository;

    public ClienteServiceImpl(IClienteRepository clienteRepository){
        this.clienteRepository = clienteRepository;
    }

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getOneById(long id) {
        return clienteRepository.findById(id);
    }

    @Override
    public Cliente create(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public void delete(long id) {
        clienteRepository.deleteById(id);
    }

}
