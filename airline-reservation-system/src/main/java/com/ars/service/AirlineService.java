package com.ars.service;

import com.ars.entity.Airline;
import com.ars.model.AirlineDTO;

public interface AirlineService {
void saveAirline(Airline airline);
void assignAirlineToFlight(int flightId, int airId);
AirlineDTO updateById(int id,Airline airline);
}
