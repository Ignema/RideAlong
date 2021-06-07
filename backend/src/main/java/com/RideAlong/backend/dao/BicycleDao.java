package com.RideAlong.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RideAlong.backend.model.Bicycle;

public interface BicycleDao extends JpaRepository<Bicycle,Integer> {

	public List<Bicycle> findByModelContains(String model);

}
