package com.RideAlong.backend.model;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.ToString;

@Entity
@Table(name="bicycle")
@Data 
@NoArgsConstructor 
@AllArgsConstructor 
@ToString
public class Bicycle {
	
	@Id 
	@GeneratedValue(strategy = GenerationType.IDENTITY)
	private int idBicycle;
	private String model; 
	private String image;
	private int price;
	private int duration;
	private boolean available;

}
