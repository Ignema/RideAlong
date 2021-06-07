package com.RideAlong.backend.controllers;

import com.RideAlong.backend.DAOs.MessageDAO;
import com.RideAlong.backend.models.Message;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.server.ResponseStatusException;

import java.util.List;
import java.util.Optional;

@RestController
public class MessageController {

    final private MessageDAO messageDAO;

    public MessageController(MessageDAO messageDAO) {
        this.messageDAO = messageDAO;
    }

    @GetMapping("/message")
    public List<Message> getMessages() {
        return messageDAO.getAll();
    }

    @GetMapping("/message/{id}")
    public Message getMessage(@PathVariable String id) {
        Optional<Message> message = messageDAO.get(Long.parseLong(id));
        if(message.isPresent())
            return message.get();
        else
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "message not found");
    }

    @PostMapping("/message")
    public Message insertMessage(@RequestBody Message message) {
        return messageDAO.save(message);
    }

    @PutMapping("/message")
    public Message updateMessage(@RequestBody Message message) {
        return messageDAO.save(message);
    }

    @DeleteMapping("/message/{id}")
    public Message deleteMessage(@PathVariable String id) {
        Optional<Message> message = messageDAO.get(Long.parseLong(id));
        message.ifPresentOrElse(messageDAO::delete, () -> {
            throw new ResponseStatusException(HttpStatus.NOT_FOUND, "message not found");
        });
        return message.get();
    }
}