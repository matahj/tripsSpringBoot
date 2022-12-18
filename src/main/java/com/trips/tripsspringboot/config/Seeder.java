package com.trips.tripsspringboot.config;

import com.trips.tripsspringboot.entity.Autobus;
import com.trips.tripsspringboot.entity.Cliente;
import com.trips.tripsspringboot.entity.Terminal;
import com.trips.tripsspringboot.repository.IAutobusRepository;
import com.trips.tripsspringboot.repository.IClienteRepository;
import com.trips.tripsspringboot.repository.ITerminalRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

import java.util.Optional;

@Slf4j
@AllArgsConstructor
@Component
public class Seeder implements CommandLineRunner {

    private IClienteRepository clienteRepository;
    private ITerminalRepository terminalRepository;
    private IAutobusRepository autobusRepository;

    @Override
    public void run(String... args) throws Exception {

        log.info("Inicializando Base de Datos...");

        Cliente clarad = clienteRepository.findClienteByEmail("clarad@trips.com");
        if(clarad == null){
            Cliente c = new Cliente();
            c.setNombreCompletoCl("Clara Dorantes");
            c.setEmail("clarad@trips.com");
            c.setTelefono("1234567890");
            clienteRepository.save(c);
        }
        Cliente pedroa = clienteRepository.findClienteByEmail("pedroa@trips.com");
        if(pedroa == null){
            Cliente c = new Cliente();
            c.setNombreCompletoCl("Pedro Aleman");
            c.setEmail("pedroa@trips.com");
            c.setTelefono("2345678901");
            clienteRepository.save(c);
        }

        Terminal cdmx = terminalRepository.findTerminalByLocalidadAndDireccion("CDMX","Sur");
        if(cdmx == null){
            Terminal t = new Terminal();
            t.setLocalidad("CDMX");
            t.setDireccion("Sur");
            terminalRepository.save(t);
        }

        Terminal toluca = terminalRepository.findTerminalByLocalidadAndDireccion("Toluca","Centro");
        if(toluca == null){
            Terminal t = new Terminal();
            t.setLocalidad("Toluca");
            t.setDireccion("Centro");
            terminalRepository.save(t);
        }

        Autobus a1234 = autobusRepository.getAutobusByMatricula("a1234");
        if(a1234 == null){
            Optional<Terminal> t = terminalRepository.findById((long)1);

            if(t.isPresent()){
                Autobus a = new Autobus();
                a.setMatricula("a1234");
                a.setClase("Primera");
                a.setEstadoMecanico("Operativo");
                a.setModelo("2022");
                a.setTerminal(t.get());
                autobusRepository.save(a);
            }
        }

        Autobus b1234 = autobusRepository.getAutobusByMatricula("b1234");
        if(b1234 == null){
            Optional<Terminal> t = terminalRepository.findById((long)2);

            if(t.isPresent()){
                Autobus a = new Autobus();
                a.setMatricula("b1234");
                a.setClase("Primera");
                a.setEstadoMecanico("Operativo");
                a.setModelo("2020");
                a.setTerminal(t.get());
                autobusRepository.save(a);
            }
        }

        log.info("Base de datos inicializada.");
    }
}
