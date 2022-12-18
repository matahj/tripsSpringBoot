package com.trips.tripsspringboot.controller;

import com.trips.tripsspringboot.entity.Autobus;
import com.trips.tripsspringboot.service.IAutobusService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/autobuses")
public class AutobsController {

    private IAutobusService autobusService;

    @GetMapping
    @ResponseStatus(HttpStatus.OK)
    public List<Autobus> getAll(){
        return autobusService.getAll();
    }

    @GetMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Optional<Autobus> getOneById(@PathVariable("id") long id){
        return autobusService.getOneById(id);
    }


    @PostMapping("/{id}")
    @ResponseStatus(HttpStatus.OK)
    public Autobus create(@PathVariable("id") long id, @RequestBody Autobus autobus){
        return autobusService.create(id, autobus);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Autobus update(@PathVariable("id") long id, @RequestBody Autobus autobus){
        return autobusService.upedate(id, autobus);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
        autobusService.delete(id);
    }
}
