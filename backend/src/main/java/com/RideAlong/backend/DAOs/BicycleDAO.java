package com.RideAlong.backend.DAOs;

import com.RideAlong.backend.models.Bicycle;
import com.RideAlong.backend.models.Participant;
import com.RideAlong.backend.repositories.BicycleRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Repository;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Repository
public class BicycleDAO implements DAO<Bicycle> {

    final private BicycleRepository bicycleRepository;
    final private ParticipantDAO participantDAO;

    public BicycleDAO(BicycleRepository bicycleRepository, ParticipantDAO participantDAO) {
        this.bicycleRepository = bicycleRepository;
        this.participantDAO = participantDAO;
    }

    @Override
    public Optional<Bicycle> get(long id) {
        return this.bicycleRepository.findById(id);
    }

    @Override
    public List<Bicycle> getAll() {
        return this.bicycleRepository.findAll();
    }

    @Override
    public Bicycle save(Bicycle bicycle) {
        return this.bicycleRepository.save(bicycle);
    }

    @Override
    public Bicycle update(Bicycle bicycle) {
        return this.bicycleRepository.save(bicycle);
    }

    @Override
    public Bicycle delete(Bicycle bicycle) {
        this.bicycleRepository.delete(bicycle);
        return bicycle;
    }

    public List<Bicycle> getUserBicycles(long id) {
        Optional<Participant> participant = participantDAO.get(id);
        if(participant.isPresent()){
            List<Bicycle> allBicycles = getAll();
            return allBicycles.stream().filter(bicycle -> {
                if(bicycle.getParticipant() != null){
                   return bicycle.getParticipant().equals(participant.get());
                } else {
                    return false;
                }
            }).collect(Collectors.toList());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "participant not found");
        }
    }

    public List<Bicycle> getUserOwnedBicycles(long id) {
        Optional<Participant> participant = participantDAO.get(id);
        if(participant.isPresent()){
            List<Bicycle> allBicycles = getAll();
            return allBicycles.stream().filter(bicycle -> bicycle.getOwner().equals(participant.get())).collect(Collectors.toList());
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "participant not found");
        }
    }

    public Boolean isUseOwnerOrRenter(long bicycle_id, long user_id) {
        Optional<Participant> participant = participantDAO.get(user_id);
        Optional<Bicycle> bicycle = get(bicycle_id);
        if (bicycle.isPresent() && participant.isPresent()){
            if(bicycle.get().getParticipant()!=null){
                return bicycle.get().getParticipant().equals(participant.get()) || bicycle.get().getOwner().equals(participant.get());
            } else {
                return bicycle.get().getOwner().equals(participant.get());
            }
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "participant or meetup not found");
        }
    }

    public Bicycle rentBicycle(long bicycle_id, long user_id) {
        Optional<Participant> participant = participantDAO.get(user_id);
        Optional<Bicycle> bicycle = get(bicycle_id);
        if (bicycle.isPresent() && participant.isPresent()){
            if(isUseOwnerOrRenter(bicycle_id, user_id)){
                throw new ResponseStatusException(HttpStatus.FORBIDDEN, "user has already rented the bicycle");
            }
            Bicycle newBicycle = bicycle.get();
            newBicycle.setAvailable(false);
            newBicycle.setParticipant(participant.get());
            return update(newBicycle);
        } else {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "participant or meetup not found");
        }
    }
}
