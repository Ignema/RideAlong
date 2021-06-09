package com.RideAlong.backend.security;

import com.RideAlong.backend.DAOs.ParticipantDAO;
import com.RideAlong.backend.models.Participant;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.ArrayList;

@Service
public class MyUserDetails implements UserDetailsService {

    final private ParticipantDAO participantDAO;

    public MyUserDetails(ParticipantDAO participantDAO) {
        this.participantDAO = participantDAO;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Participant participant = participantDAO.getParticipantByEmail(email);
        return new User(participant.getEmail(), participant.getPassword(), new ArrayList<>());
    }
}