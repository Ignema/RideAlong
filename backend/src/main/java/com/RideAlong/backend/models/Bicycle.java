package com.RideAlong.backend.models;

import lombok.Data;

import javax.persistence.*;

@Data
@Entity(name = "Bicycle")
public class Bicycle {
    @Id
    @SequenceGenerator(name = "bicycle_sequence", sequenceName = "bicycle_sequence", allocationSize = 1)
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "bicycle_sequence")
    @Column(name = "bicycle_id", updatable = false)
    private Long id;

    @Column(name = "model", nullable = false, columnDefinition = "TEXT")
    private String model;

    @Column(name = "image", columnDefinition = "TEXT")
    private String image;

    @Column(name = "price", nullable = false, columnDefinition = "INT")
    private Integer price;

    @Column(name = "duration", nullable = false, columnDefinition = "INT")
    private Integer duration;

    @Column(name = "available", nullable = false, columnDefinition = "BOOLEAN")
    private Boolean available;

    @OneToOne
    @JoinColumn(name = "participant_id")
    private Participant participant;

    @ManyToOne
    @JoinTable(name = "owner", joinColumns = @JoinColumn(name = "bicycle_id"), inverseJoinColumns = @JoinColumn(name = "participant_id"))
    private Participant owner;
}