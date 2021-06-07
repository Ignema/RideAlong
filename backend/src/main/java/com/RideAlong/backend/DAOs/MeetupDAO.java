package com.RideAlong.backend.DAOs;

import com.RideAlong.backend.models.Meetup;
import com.RideAlong.backend.repositories.MeetupRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MeetupDAO implements DAO<Meetup> {

    final private MeetupRepository meetupRepository;

    public MeetupDAO(MeetupRepository meetupRepository) {
        this.meetupRepository = meetupRepository;
    }

    @Override
    public Optional<Meetup> get(long id) {
        return this.meetupRepository.findById(id);
    }

    @Override
    public List<Meetup> getAll() {
        return this.meetupRepository.findAll();
    }

    @Override
    public Meetup save(Meetup meetup) {
        return this.meetupRepository.save(meetup);
    }

    @Override
    public Meetup update(Meetup meetup) {
        return this.meetupRepository.save(meetup);
    }

    @Override
    public Meetup delete(Meetup meetup) {
        this.meetupRepository.delete(meetup);
        return meetup;
    }
}
