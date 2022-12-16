package com.trips.tripsspringboot.controller;

import com.trips.tripsspringboot.entity.Terminal;
import com.trips.tripsspringboot.service.ITerminalService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Optional;

@RestController
public class TerminalController {

    private ITerminalService terminalService;

    public TerminalController(ITerminalService terminalService){
        this.terminalService = terminalService;
    }

    @GetMapping("/getAllTerminal")
    public List<Terminal> getAll(){
        return terminalService.getAll();
    }

    @GetMapping("/getOneTerminal/{idTerminal}")
    public Optional<Terminal> getOneById(@PathVariable("idTerminal") long idTerminal){
        return terminalService.getOneById(idTerminal);
    }
}
