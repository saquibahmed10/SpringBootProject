package com.ars.serviceimpl;

import java.time.LocalDate;
import java.util.List;

import com.ars.dao.FlightDAO;
import com.ars.daoimpl.FlightDAOImpl;
import com.ars.entity.Flight;
import com.ars.exception.GlobalException;
import com.ars.model.FlightDTO;
import com.ars.service.FlightService;


public class FlightServiceImpl implements FlightService{

	FlightDAO flightDAO=new FlightDAOImpl();
	@Override
	public void saveFlight(Flight flight) {
		flightDAO.saveFlight(flight);
		
	}

	@Override
	public FlightDTO updateFlight(int id, Flight flight) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public FlightDTO getFlight(int id) throws GlobalException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public void deleteFlight(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Flight> checkFlight(String from, String to,LocalDate date) {
		
		return flightDAO.checkFlight(from, to,date);
	}

}
