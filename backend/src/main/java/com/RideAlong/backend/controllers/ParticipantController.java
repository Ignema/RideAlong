package com.RideAlong.backend.controllers;

import com.RideAlong.backend.DAOs.ParticipantDAO;
import com.RideAlong.backend.models.Participant;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class ParticipantController {

    final private ParticipantDAO participantDAO;

    public ParticipantController(ParticipantDAO participantDAO) {
        this.participantDAO = participantDAO;
    }

    @GetMapping("/participant")
    public List<Participant> getParticipants() {
        return participantDAO.getAll();
    }

    @GetMapping("/participant/{id}")
    public Participant getParticipant(@PathVariable String id) {
        Optional<Participant> participant = participantDAO.get(Long.parseLong(id));
        if(participant.isPresent())
            return participant.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "participant not found");
    }

    @GetMapping("/login")
    public Participant getPartipantByEmailPASS(@RequestBody Participant participant) {
        Participant participant1 = participantDAO.getParticipantByEmailAndPassword(participant.getEmail(),participant.getPassword());
        if(participant1!=null)return participant1;
        else throw new ResponseStatusException(HttpStatus.NOT_FOUND, "participant not found");
    }

    @PostMapping("/participant")
    public Participant insertParticipant(@RequestBody Participant participant) {

        participant.setPassword(""+participant.getPassword().hashCode());
        return participantDAO.save(participant);
    }

    @PutMapping("/participant")
    public Participant updateParticipant(@RequestBody Participant participant) {
        return participantDAO.save(participant);
    }

    @DeleteMapping("/participant/{id}")
    public Participant deleteParticipant(@PathVariable String id) {
        Optional<Participant> participant = participantDAO.get(Long.parseLong(id));
        participant.ifPresentOrElse(participantDAO::delete, () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "participant not found");
        });
        return participant.get();
    }
}