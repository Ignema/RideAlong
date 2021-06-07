package com.RideAlong.backend.dao;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RideAlong.backend.model.Participant;

public interface ParticipantDao extends JpaRepository<Participant,Integer> {
	
	public List<Participant> findByNameContains(String name);

}
