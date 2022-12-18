package com.trips.tripsspringboot.service.impl;

import com.trips.tripsspringboot.entity.Autobus;
import com.trips.tripsspringboot.entity.Terminal;
import com.trips.tripsspringboot.repository.IAutobusRepository;
import com.trips.tripsspringboot.repository.ITerminalRepository;
import com.trips.tripsspringboot.service.IAutobusService;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Service
public class AutobusServiceImpl implements IAutobusService {

    private IAutobusRepository repository;
    private ITerminalRepository terminalRepository;

    @Override
    public List<Autobus> getAll() {
        return repository.findAll();
    }

    @Override
    public Optional<Autobus> getOneById(long id) {
        return repository.findById(id);
    }

    @Override
    public Autobus getAutobusByMatricula(String matricula) {
        return repository.getAutobusByMatricula(matricula);
    }

    @Override
    public Autobus create(long id, Autobus autobus) {
        Autobus a = repository.getAutobusByMatricula(autobus.getMatricula());
        if(a==null){
            Optional<Terminal> t = terminalRepository.findById((long)id);
            if(t.isPresent()){
                Autobus nuevo = new Autobus();
                nuevo.setMatricula(autobus.getMatricula());
                nuevo.setClase(autobus.getClase());
                nuevo.setEstadoMecanico(autobus.getEstadoMecanico());
                nuevo.setModelo(autobus.getModelo());
                nuevo.setTerminal(t.get());
                return repository.save(nuevo);
            }
        }
        return null;
    }

    @Override
    public Autobus upedate(long id, Autobus autobus) {
        Optional<Autobus> a = repository.findById(id);
        if(a.isPresent()){
            Autobus nuevo = a.get();
            nuevo.setMatricula(autobus.getMatricula());
            nuevo.setClase(autobus.getClase());
            nuevo.setEstadoMecanico(autobus.getEstadoMecanico());
            nuevo.setModelo(autobus.getModelo());
            return repository.save(nuevo);
        }
        return null;
    }

    @Override
    public void delete(long id) {
        Optional<Autobus> a = repository.findById(id);

        if(!a.isEmpty()){
            repository.deleteById(id);
            log.info("Autobus {} borrado", id);
        } else {
            log.info("Autobus {} NO ENCONTRADO", id);
        }
    }
}
