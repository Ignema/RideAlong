package com.RideAlong.backend.DAOs;

import com.RideAlong.backend.models.Participant;
import com.RideAlong.backend.repositories.ParticipantRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class ParticipantDAO implements DAO<Participant>{

    final private ParticipantRepository participantRepository;

    public ParticipantDAO(ParticipantRepository participantRepository) {
        this.participantRepository = participantRepository;
    }

    @Override
    public Optional<Participant> get(long id) {
        return this.participantRepository.findById(id);
    }

    @Override
    public List<Participant> getAll() {
        return this.participantRepository.findAll();
    }

    @Override
    public Participant save(Participant participant) {
        return this.participantRepository.save(participant);
    }

    @Override
    public Participant update(Participant participant) {
        return this.participantRepository.save(participant);
    }

    @Override
    public Participant delete(Participant participant) {
        this.participantRepository.delete(participant);
        return participant;
    }

    public Participant getParticipantByEmail(String email){
        return participantRepository.getParticipantByEmail(email);
    }

    public Participant getParticipantByEmailAndPassword(String email,String password){
        return participantRepository.getParticipantByEmailAndPassword(email,""+password.hashCode());
    }
}
