package com.trips.tripsspringboot.service.impl;

import com.trips.tripsspringboot.entity.Terminal;
import com.trips.tripsspringboot.repository.ITerminalRepository;
import com.trips.tripsspringboot.service.ITerminalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class TerminalServiceImpl implements ITerminalService {

    private ITerminalRepository terminalRepository;

    @Autowired
    public TerminalServiceImpl(ITerminalRepository terminalRepository){
        this.terminalRepository = terminalRepository;
    }

    @Override
    public List<Terminal> getAll() {
        return terminalRepository.findAll();
    }

    @Override
    public Optional<Terminal> getOneById(long idTerminal){
        return terminalRepository.findById(idTerminal);
    }

    @Override
    public Terminal create(Terminal terminal) {
        return terminalRepository.save(terminal);
    }
}
