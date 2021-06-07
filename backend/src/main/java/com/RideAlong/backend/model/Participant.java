package com.RideAlong.backend.model;

import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.persistence.Temporal;
import javax.persistence.TemporalType;

import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.AllArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="participant")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@ToString
public class Participant {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idParticipant;
	private String name;
	private String email;
	private int phone;
	@Temporal(TemporalType.DATE)
	private Date birthday;

}
