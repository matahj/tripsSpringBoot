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
    @ResponseStatus(HttpStatus.OK)
    public List<Cliente> getAll(){
        return clienteService.getAll();
    }

    @GetMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Cliente> getOneById(@PathVariable("id") long id){
        return clienteService.getOneById(id);
    }

    @PostMapping("/clientes")
    public Cliente create(@RequestBody Cliente cliente){


        Cliente c = clienteService.getOneByEmail(cliente.getEmail());
        if(c==null){
            return clienteService.create(cliente);
        }else {
            return null;
        }
    }

    @PutMapping("/clientes/{id}")
    public Cliente update(@PathVariable("id") long id, @RequestBody Cliente cliente){
        Optional<Cliente> anterior = clienteService.getOneById(id);

        if(anterior.isPresent()){
            Cliente nuevo = anterior.get();
            nuevo.setNombreCompletoCl(cliente.getNombreCompletoCl());
            nuevo.setEmail(cliente.getEmail());
            nuevo.setTelefono(cliente.getTelefono());

            return clienteService.create(nuevo);
        }else {
            return null;
        }

    }

    @DeleteMapping("/clientes/{id}")
    @ResponseStatus(HttpStatus.ACCEPTED)
    public void delete(@PathVariable("id") long id){
        Optional<Cliente> c = clienteService.getOneById(id);

        if( !c.isEmpty() ){
            clienteService.delete(id);
            log.info("Cliente {} borrado", id);
        }else {
            log.info("Cliente {} NO ENCONTRADO", id);
        }
    }

}
