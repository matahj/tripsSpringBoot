package com.trips.tripsspringboot.controller;

import com.trips.tripsspringboot.entity.Cliente;
import com.trips.tripsspringboot.service.IClienteService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/clientes")
public class clienteController {

    private IClienteService clienteService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> getAll(){
        return clienteService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Cliente> getOneById(@PathVariable("id") long id){
        return clienteService.getOneById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.OK)
    public Cliente create(@RequestBody Cliente cliente){
        return clienteService.create(cliente);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Cliente update(@PathVariable("id") long id, @RequestBody Cliente cliente){
        return clienteService.update(id, cliente);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
        clienteService.delete(id);
    }
}
