package com.RideAlong.backend.DAOs;

import com.RideAlong.backend.models.Meetup;
import com.RideAlong.backend.models.Participant;
import com.RideAlong.backend.repositories.MeetupRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class MeetupDAO implements DAO<Meetup> {

    final private MeetupRepository meetupRepository;
    final private ParticipantDAO participantDAO;

    public MeetupDAO(MeetupRepository meetupRepository, ParticipantDAO participantDAO) {
        this.meetupRepository = meetupRepository;
        this.participantDAO = participantDAO;
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

    public List<Meetup> getUserMeetups(long id) {
        Optional<Participant> participant = participantDAO.get(id);
        if(participant.isPresent()){
            List<Meetup> allMeetups = getAll();
            return allMeetups.stream().filter(meetup -> meetup.getParticipants().contains(participant.get())).collect(Collectors.toList());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "participant not found");
        }
    }

    public List<Meetup> getUserOrganizedMeetups(long id) {
        Optional<Participant> participant = participantDAO.get(id);
        if(participant.isPresent()){
            List<Meetup> allMeetups = getAll();
            return allMeetups.stream().filter(meetup -> meetup.getOrganizer().equals(participant.get())).collect(Collectors.toList());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "participant not found");
        }
    }

    public Boolean isUserInThisMeetup(long meetup_id, long user_id) {
        Optional<Participant> participant = participantDAO.get(user_id);
        Optional<Meetup> meetup = get(meetup_id);
        if (meetup.isPresent() && participant.isPresent()){
            return meetup.get().getParticipants().contains(participant.get()) || meetup.get().getOrganizer().equals(participant.get());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "participant or meetup not found");
        }
    }

    public Meetup addParticipantToMeetup(long meetup_id, long user_id) {
        Optional<Participant> participant = participantDAO.get(user_id);
        Optional<Meetup> meetup = get(meetup_id);
        if (meetup.isPresent() && participant.isPresent()){
            if(isUserInThisMeetup(meetup_id, user_id)){
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "participant already in meetup");
            }
            Meetup newMeetup = meetup.get();

            List<Participant> newParticipants = newMeetup.getParticipants();
            newParticipants.add(participant.get());

            newMeetup.setParticipants(newParticipants);
            return update(newMeetup);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "participant or meetup not found");
        }
    }
}
