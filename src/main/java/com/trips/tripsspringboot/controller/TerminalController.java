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
public class TerminalController {

    private ITerminalService terminalService;

    @GetMapping("/terminales")
    public List<Terminal> getAll(){
        return terminalService.getAll();
    }

    @GetMapping("/terminales/{id}")
    public Optional<Terminal> getOneById(@PathVariable("id") long id){
        return terminalService.getOneById(id);
    }

    @PostMapping("/terminales")
    @ResponseStatus(HttpStatus.CREATED)
    public Terminal create(@RequestBody Terminal terminal){
        return terminalService.create(terminal);
    }
}
