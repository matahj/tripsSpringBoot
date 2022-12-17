package com.trips.tripsspringboot.service.impl;

import com.trips.tripsspringboot.entity.Terminal;
import com.trips.tripsspringboot.repository.ITerminalRepository;
import com.trips.tripsspringboot.service.ITerminalService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;
import org.yaml.snakeyaml.events.Event;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class TerminalServiceImpl implements ITerminalService {

    private ITerminalRepository terminalRepository;

    @Override
    public List<Terminal> getAll() {
        return terminalRepository.findAll();
    }

    @Override
    public Optional<Terminal> getOneById(long id){
        return terminalRepository.findById(id);
    }

    public Terminal findOneByLocalidadAndDireccion(String localidad, String direccion){
        return terminalRepository.findTerminalByLocalidadAndDireccion(localidad, direccion);
    }

    @Override
    public Terminal create(Terminal terminal) {
        Terminal t = terminalRepository.findTerminalByLocalidadAndDireccion(terminal.getLocalidad(), terminal.getDireccion());

        if(t==null){
            return terminalRepository.save(terminal);
        } else {
            return null;
        }
    }

    public void delete(long id){
        Optional<Terminal> t = terminalRepository.findById(id);

        if( !t.isEmpty() ){
            terminalRepository.deleteById(id);
            log.info("Terminal {} borrada", id);
        } else {
            log.info("Terminal {} NO ENCONTRADA", id);
        }
    }

    public Terminal update(long id, Terminal terminal){
        Optional<Terminal> ter = terminalRepository.findById(id);

        if(ter.isPresent()){
            Terminal nuevo = ter.get();
            nuevo.setLocalidad( terminal.getLocalidad() );
            nuevo.setDireccion( terminal.getDireccion() );
            return terminalRepository.save(nuevo);
        } else {
            return null;
        }
    }
}
