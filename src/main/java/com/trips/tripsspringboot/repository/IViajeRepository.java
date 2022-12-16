package com.trips.tripsspringboot.repository;

import com.trips.tripsspringboot.entity.Viaje;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IViajeRepository extends JpaRepository<Viaje, Long> {
}
