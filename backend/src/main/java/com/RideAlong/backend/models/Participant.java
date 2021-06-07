package com.RideAlong.backend.models;

import lombok.Data;

import javax.persistence.*;
import java.time.LocalDate;
import java.util.List;


@Data
@Entity(name = "Participant")
public class Participant {
    @Id
    @SequenceGenerator(name = "participant_sequence", sequenceName = "participant_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "participant_sequence")
    @Column(name = "participant_id", updatable = false)
    private Long id;

    @Column(name = "name", nullable = false, columnDefinition = "TEXT")
    private String name;

    @Column(name = "email", nullable = false, unique = true, columnDefinition = "TEXT")
    private String email;

    @Column(name = "phone", nullable = false, unique = true, columnDefinition = "INT")
    private Integer phone;

    @Column(name = "birthday", nullable = false, columnDefinition = "DATE")
    private LocalDate birthday;

    @OneToOne
    @JoinColumn(name = "message_id")
    private Bicycle bicycle;

    @ManyToMany
    @JoinTable(name = "participant_meetup", joinColumns = @JoinColumn(name = "participant_id"), inverseJoinColumns = @JoinColumn(name = "meetup_id"))
    @Column(name = "meetups")
    private List<Meetup> meetups;

    @OneToMany(mappedBy = "organizer")
    @Column(name = "organized_meetups")
    private List<Meetup> organized_meetups;

    @OneToMany(mappedBy = "owner")
    @Column(name = "owned_bicycles")
    private List<Bicycle> bicycles;
}