package com.trips.tripsspringboot.controller;

import com.trips.tripsspringboot.entity.Cliente;
import com.trips.tripsspringboot.service.IClienteService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class clienteController {

    private IClienteService clienteService;

    public clienteController(IClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping("/getAllCliente")
    public List<Cliente> getAll(){
        return clienteService.getAll();
    }

    @GetMapping("/getOneCliente/{id}")
    public Optional<Cliente> getOne(@PathVariable("id") long id){
        return clienteService.getOneById(id);
    }
}
