package com.RideAlong.backend.repositories;

import com.RideAlong.backend.models.Message;
import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long> {

}