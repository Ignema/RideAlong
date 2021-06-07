package com.RideAlong.backend.DAOs;

import com.RideAlong.backend.models.Message;
import com.RideAlong.backend.repositories.MessageRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public class MessageDAO implements DAO<Message> {

    final private MessageRepository messageRepository;

    public MessageDAO(MessageRepository messageRepository) {
        this.messageRepository = messageRepository;
    }

    @Override
    public Optional<Message> get(long id) {
        return this.messageRepository.findById(id);
    }

    @Override
    public List<Message> getAll() {
        return this.messageRepository.findAll();
    }

    @Override
    public Message save(Message message) {
        return this.messageRepository.save(message);
    }

    @Override
    public Message update(Message message) {
        return this.messageRepository.save(message);
    }

    @Override
    public Message delete(Message message) {
        this.messageRepository.delete(message);
        return message;
    }
}
