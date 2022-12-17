package com.trips.tripsspringboot.controller;

import com.trips.tripsspringboot.entity.Terminal;
import com.trips.tripsspringboot.service.ITerminalService;
import lombok.AllArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Optional;

@AllArgsConstructor
@RestController
@RequestMapping("/terminales")
public class TerminalController {

    private ITerminalService terminalService;

    @GetMapping
    public List<Terminal> getAll(){
        return terminalService.getAll();
    }

    @GetMapping("/{id}")
    public Optional<Terminal> getOneById(@PathVariable("id") long id){
        return terminalService.getOneById(id);
    }

    @PostMapping
    @ResponseStatus(HttpStatus.CREATED)
    public Terminal create(@RequestBody Terminal terminal){
        return terminalService.create(terminal);
    }

    @PutMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public Terminal update(@PathVariable("id") long id, @RequestBody Terminal terminal){
        return terminalService.update(id, terminal);
    }

    @DeleteMapping("/{id}")
    @ResponseStatus(HttpStatus.NO_CONTENT)
    public void delete(@PathVariable("id") long id){
        terminalService.delete(id);
    }
}
