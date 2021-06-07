package com.RideAlong.backend.controllers;

import com.RideAlong.backend.DAOs.MeetupDAO;
import com.RideAlong.backend.models.Meetup;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class MeetupController {

    final private MeetupDAO meetupDAO;

    public MeetupController(MeetupDAO meetupDAO) {
        this.meetupDAO = meetupDAO;
    }

    @GetMapping("/meetup")
    public List<Meetup> getMeetups() {
        return meetupDAO.getAll();
    }

    @GetMapping("/meetup/{id}")
    public Meetup getMeetup(@PathVariable String id) {
        Optional<Meetup> meetup = meetupDAO.get(Long.parseLong(id));
        if(meetup.isPresent())
            return meetup.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "meetup not found");
    }

    @PostMapping("/meetup")
    public Meetup insertMeetup(@RequestBody Meetup meetup) {
        return meetupDAO.save(meetup);
    }

    @PutMapping("/meetup")
    public Meetup updateMeetup(@RequestBody Meetup meetup) {
        return meetupDAO.save(meetup);
    }

    @DeleteMapping("/meetup/{id}")
    public Meetup deleteMeetup(@PathVariable String id) {
        Optional<Meetup> meetup = meetupDAO.get(Long.parseLong(id));
        meetup.ifPresentOrElse(meetupDAO::delete, () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "meetup not found");
        });
        return meetup.get();
    }
}