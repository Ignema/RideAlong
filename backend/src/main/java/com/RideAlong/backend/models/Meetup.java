package com.RideAlong.backend.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Data
@Entity(name = "Meetup")
public class Meetup {
    @Id
    @SequenceGenerator(name = "meetup_sequence", sequenceName = "meetup_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "meetup_sequence")
    @Column(name = "meetup_id", updatable = false)
    private Long id;

    @Column(name = "date", nullable = false, columnDefinition = "TIMESTAMP")
    private LocalDateTime date;

    @Column(name = "location", nullable = false, columnDefinition = "TEXT")
    private String location;

    @Column(name = "completed", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean completed;

    @Column(name = "gallery", columnDefinition = "TEXT")
    private String gallery;

    @ManyToMany(mappedBy = "meetups")
    @Column(name = "participants")
    private List<Participant> participants;

    @ManyToOne
    @JoinTable(name="organizer", joinColumns = @JoinColumn(name = "meetup_id", referencedColumnName = "meetup_id"), inverseJoinColumns = @JoinColumn(name = "participant_id", referencedColumnName = "participant_id"))
    private Participant organizer;

    @OneToMany(mappedBy = "messaged_meetup")
    @Column(name = "messages")
    private List<Message> messages;
}