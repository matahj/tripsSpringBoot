package com.trips.tripsspringboot.controller;

import com.trips.tripsspringboot.entity.Cliente;
import com.trips.tripsspringboot.service.IClienteService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@RestController
public class clienteController {

    private IClienteService clienteService;

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

    @DeleteMapping("/clientes/{id}")
    public void delete(@PathVariable("id") long id){
        clienteService.delete(id);
        log.info("Cliente {} borrado", id);
    }

    @PutMapping("/clientes/{id}")
    public Cliente update(@PathVariable("id") long id, @RequestBody Cliente cliente){
        Optional<Cliente> anterior = clienteService.getOneById(id);

        Cliente nuevo = anterior.get();
        nuevo.setNombreCompletoCl(cliente.getNombreCompletoCl());
        nuevo.setEmail(cliente.getEmail());
        nuevo.setTelefono(cliente.getTelefono());

        return clienteService.create(nuevo);
    }

}
