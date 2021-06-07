package com.RideAlong.backend.dao;

import org.springframework.data.jpa.repository.JpaRepository;

import com.RideAlong.backend.model.Message;

public interface MessageDao extends JpaRepository<Message,Integer> {

}
