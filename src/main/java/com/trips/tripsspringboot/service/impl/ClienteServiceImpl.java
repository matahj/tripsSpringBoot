package com.trips.tripsspringboot.service.impl;

import com.trips.tripsspringboot.entity.Cliente;
import com.trips.tripsspringboot.repository.IClienteRepository;
import com.trips.tripsspringboot.service.IClienteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class ClienteServiceImpl implements IClienteService {

    private IClienteRepository clienteRepository;

    @Override
    public List<Cliente> getAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Optional<Cliente> getOneById(long id) {
        return clienteRepository.findById(id);
    }

    public Cliente getOneByEmail(String email){
        return clienteRepository.findClienteByEmail(email);
    }

    @Override
    public Cliente create(Cliente cliente) {
        Cliente c = clienteRepository.findClienteByEmail(cliente.getEmail());
        if(c==null){
            return clienteRepository.save(cliente);
        }else {
            return null;
        }
    }

    @Override
    public void delete(long id) {
        Optional<Cliente> c = clienteRepository.findById(id);

        if( !c.isEmpty() ){
            clienteRepository.deleteById(id);
            log.info("Cliente {} borrado", id);
        }else {
            log.info("Cliente {} NO ENCONTRADO", id);
        }
    }

    @Override
    public Cliente update(long id, Cliente cliente) {
        Optional<Cliente> cl = clienteRepository.findById(id);

        if( cl.isPresent() ){
            Cliente nuevo = cl.get();
            nuevo.setNombreCompletoCl(cliente.getNombreCompletoCl());
            nuevo.setEmail( cliente.getEmail() );
            nuevo.setTelefono( cliente.getTelefono() );
            return clienteRepository.save(nuevo);
        }else {
            return null;
        }
    }
}
