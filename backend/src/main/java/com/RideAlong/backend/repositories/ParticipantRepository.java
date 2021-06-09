package com.RideAlong.backend.repositories;

import com.RideAlong.backend.models.Participant;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;

public interface ParticipantRepository extends JpaRepository<Participant, Long> {

    @Query(value = "select * from participant where email=?1 and password=?2", nativeQuery = true)
    Participant getParticipantByEmailAndPassword(String email,String password);

    @Query(value = "select * from participant where email=?1", nativeQuery = true)
    Participant getParticipantByEmail(String email);


}