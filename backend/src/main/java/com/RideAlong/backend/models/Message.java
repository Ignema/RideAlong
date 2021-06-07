package com.RideAlong.backend.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "Message")
public class Message {
    @Id
    @SequenceGenerator(name = "message_sequence", sequenceName = "message_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "message_sequence")
    @Column(name = "message_id", updatable = false)
    private Long id;

    @Column(name = "content", nullable = false, columnDefinition = "TEXT")
    private String content;

    @Column(name = "date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime date;

    @ManyToOne
    @JoinTable(name = "message_meetup", joinColumns = @JoinColumn(name = "message_id"), inverseJoinColumns = @JoinColumn(name = "meetup_id"))
    private Meetup messaged_meetup;
}