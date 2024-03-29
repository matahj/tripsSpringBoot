package com.trips.tripsspringboot.repository;

import com.trips.tripsspringboot.entity.Cliente;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IClienteRepository extends JpaRepository<Cliente,Long> {
    Cliente findClienteByEmail(String email);
}
