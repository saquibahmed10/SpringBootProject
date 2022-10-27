package com.ars.dao;

import java.time.LocalDate;
import java.util.List;

import com.ars.entity.Flight;

public interface FlightDAO {

	void saveFlight(Flight flight);
	Flight updateFlight(int id,Flight flight);
	Flight  getFlight(int id);
	void deleteFlight(int id);
	List<Flight> checkFlight(String from,String to,LocalDate date);
}
