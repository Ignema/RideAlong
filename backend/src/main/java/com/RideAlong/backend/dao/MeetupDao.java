package com.RideAlong.backend.dao;

import java.util.Date;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RideAlong.backend.model.Meetup;

public interface MeetupDao extends JpaRepository<Meetup,Integer> {
	
	public List<Meetup> findByLocationContains(String location);
	public List<Meetup> findByDateContains(Date date);

}
