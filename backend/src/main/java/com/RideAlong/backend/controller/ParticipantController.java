package com.RideAlong.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.RideAlong.backend.dao.ParticipantDao;
import com.RideAlong.backend.model.Participant;

@RestController
public class ParticipantController {
	
	@Autowired
	private ParticipantDao participantDao;
	
	@GetMapping("/participants")
	public List<Participant> participants(){
		return participantDao.findAll();
	}
	
	@GetMapping("/participants/{id}")
	public Participant participants(@PathVariable int id){
		return participantDao.findById(id).get();
	}
	
}
