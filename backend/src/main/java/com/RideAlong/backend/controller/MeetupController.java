package com.RideAlong.backend.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.RideAlong.backend.dao.MeetupDao;
import com.RideAlong.backend.model.Meetup;

@RestController
public class MeetupController {
	
	@Autowired
	private MeetupDao meetupDao;
	
	@GetMapping("/meetups")
	public List<Meetup> meetups(){
		return meetupDao.findAll();
	}
	
	@GetMapping("/participants/{id}")
	public Meetup meetups(@PathVariable int id){
		return meetupDao.findById(id).get();
	}

}
