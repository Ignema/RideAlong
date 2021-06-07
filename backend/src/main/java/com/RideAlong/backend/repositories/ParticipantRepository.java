package com.RideAlong.backend.repositories;

import com.RideAlong.backend.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

}