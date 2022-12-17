package com.trips.tripsspringboot.config;

import com.trips.tripsspringboot.entity.Autobus;
import com.trips.tripsspringboot.entity.Cliente;
import com.trips.tripsspringboot.entity.Terminal;
import com.trips.tripsspringboot.repository.IAutobusRepository;
import com.trips.tripsspringboot.repository.IClienteRepository;
import com.trips.tripsspringboot.repository.ITerminalRepository;
import lombok.AllArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
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

        Cliente pedroa = clienteRepository.findClienteByEmail("pedroa@trips.com");
        if(pedroa == null){
            Cliente c1 = new Cliente();
            c1.setNombreCompletoCl("Pedro Aleman");
            c1.setEmail("pedroa@trips.com");
            c1.setTelefono("1234567890");
            clienteRepository.save(c1);
        }

        Terminal cdmx = terminalRepository.findTerminalByLocalidadAndDireccion("CDMX","Sur");
        if(cdmx == null){
            Terminal t1 = new Terminal();
            t1.setLocalidad("CDMX");
            t1.setDireccion("Sur");
            terminalRepository.save(t1);
        }

        Terminal toluca = terminalRepository.findTerminalByLocalidadAndDireccion("Toluca","Centro");
        if(toluca == null){
            Terminal t2 = new Terminal();
            t2.setLocalidad("Toluca");
            t2.setDireccion("Centro");
            terminalRepository.save(t2);
        }

        /*
        Autobus a1234 = autobusRepository.getAutobusByMatricula("a1234");
        if(a1234 == null){
            Autobus a1 = new Autobus();
            a1.setMatricula("a1234");
            a1.setClase("Primera");
            a1.setEstadoMecanico("Operativo");
            a1.setModelo("2022");
            a1.setTerminal(terminalRepository.findTerminalByLocalidadAndDireccion("CDMX","Sur"));
        }
        */
    }
}
