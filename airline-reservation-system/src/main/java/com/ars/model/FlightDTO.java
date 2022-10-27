package com.ars.model;

import java.util.Date;

import javax.persistence.Column;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Temporal;


import com.ars.entity.Airline;

import lombok.Getter;
import lombok.Setter;
@Setter
@Getter
public class FlightDTO {
	private int flight_id;

	private int availableSeats;

	private int totalSeats;
	
	private String travellerClass;

	private Date time;

	private Date date;

	private String source;
	
	private String destination;

	private Airline airline;
}
