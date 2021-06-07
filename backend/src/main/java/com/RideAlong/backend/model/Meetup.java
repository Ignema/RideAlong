package com.RideAlong.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="meetup")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@ToString
public class Meetup {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMeetup;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
	private String location;
	private boolean completed;
	private String gallery;
}
