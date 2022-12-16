package com.trips.tripsspringboot.repository;

import com.trips.tripsspringboot.entity.Autobus;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IAutobusRepository extends JpaRepository<Autobus, Long> {
    Autobus getAutobusByMatricula(String matricula);
}
