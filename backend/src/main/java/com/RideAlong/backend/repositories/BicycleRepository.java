package com.RideAlong.backend.repositories;

import com.RideAlong.backend.models.Bicycle;
import org.springframework.data.jpa.repository.JpaRepository;


public interface BicycleRepository extends JpaRepository<Bicycle, Long> {

}