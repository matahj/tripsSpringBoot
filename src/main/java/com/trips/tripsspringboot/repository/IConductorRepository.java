package com.trips.tripsspringboot.repository;

import com.trips.tripsspringboot.entity.Conductor;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface IConductorRepository extends JpaRepository<Conductor, Long> {
}
