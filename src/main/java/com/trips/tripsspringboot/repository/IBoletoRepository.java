package com.trips.tripsspringboot.repository;

import com.trips.tripsspringboot.entity.Boleto;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IBoletoRepository extends JpaRepository<Boleto, Long> {
}
