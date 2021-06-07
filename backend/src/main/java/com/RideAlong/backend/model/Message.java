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
@Table(name="message")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@ToString
public class Message {

	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idMessage;
	private String content;
	@Temporal(TemporalType.TIMESTAMP)
	private Date date;
}
