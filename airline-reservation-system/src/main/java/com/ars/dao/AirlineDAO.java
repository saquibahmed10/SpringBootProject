package com.ars.dao;

import com.ars.entity.Airline;

public interface AirlineDAO {

void saveAirline(Airline airline);	
void assignAirlineToFlight(int flightId,int airId);	
Airline getAirlineByName(String name);
Airline updateById(int id,Airline airline);

}
