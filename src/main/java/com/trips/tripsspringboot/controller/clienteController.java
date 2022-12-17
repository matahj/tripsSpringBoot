package com.trips.tripsspringboot.controller;

import com.trips.tripsspringboot.entity.Cliente;
import com.trips.tripsspringboot.service.IClienteService;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@RestController
public class clienteController {

    private IClienteService clienteService;

    public clienteController(IClienteService clienteService){
        this.clienteService = clienteService;
    }

    @GetMapping("/clientes")
    public List<Cliente> getAll(){
        return clienteService.getAll();
    }

    @GetMapping("/clientes/{id}")
    public Optional<Cliente> getOneById(@PathVariable("id") long id){
        return clienteService.getOneById(id);
    }

    @PostMapping("/clientes")
    @ResponseStatus(HttpStatus.CREATED)
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.create(cliente);
    }

}
