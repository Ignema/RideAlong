package com.RideAlong.backend.controllers;

import com.RideAlong.backend.DAOs.ParticipantDAO;
import com.RideAlong.backend.models.Participant;
import com.RideAlong.backend.models.auth.Request;
import com.RideAlong.backend.models.auth.Response;
import com.RideAlong.backend.security.JwtUtil;
import org.springframework.http.HttpStatus;
import org.springframework.security.core.userdetails.User;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

@RestController
public class ParticipantController {

    final private ParticipantDAO participantDAO;
    final private JwtUtil jwtUtil;

    public ParticipantController(ParticipantDAO participantDAO, JwtUtil jwtUtil) {
        this.participantDAO = participantDAO;
        this.jwtUtil = jwtUtil;
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

    @PostMapping("/signup")
    public String insertParticipant(@RequestBody Participant participant) {
        participant.setPassword(""+participant.getPassword().hashCode());
        participantDAO.save(participant);
        return "Successfully created participant!";
    }

    @PostMapping("/login")
    public Response verifyParticipant(@RequestBody Request request) {
        Participant retrievedParticipant = participantDAO.getParticipantByEmailAndPassword(request.getEmail(), request.getPassword());
        if(retrievedParticipant != null)
            return new Response(jwtUtil.generateToken(new User(retrievedParticipant.getEmail(), retrievedParticipant.getPassword(), new ArrayList<>())), retrievedParticipant.getId().toString());
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "participant not found");
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