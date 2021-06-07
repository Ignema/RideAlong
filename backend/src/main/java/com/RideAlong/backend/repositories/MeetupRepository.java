package com.RideAlong.backend.repositories;

import com.RideAlong.backend.models.Meetup;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MeetupRepository extends JpaRepository<Meetup, Long> {

}