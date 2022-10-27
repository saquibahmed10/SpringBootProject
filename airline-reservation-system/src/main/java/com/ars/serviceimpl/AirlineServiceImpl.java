package com.ars.serviceimpl;

import org.modelmapper.ModelMapper;

import com.ars.dao.AirlineDAO;
import com.ars.daoimpl.AirlineDAOImpl;
import com.ars.entity.Airline;
import com.ars.model.AirlineDTO;
import com.ars.service.AirlineService;

public class AirlineServiceImpl implements AirlineService{

	AirlineDAO airlineDAO=new AirlineDAOImpl();
	
	@Override
	public void saveAirline(Airline airline) {
		airlineDAO.saveAirline(airline);
		
	}

	@Override
	public void assignAirlineToFlight(int flightId, int airId) {
		airlineDAO.assignAirlineToFlight(flightId, airId);
		
	}

	@Override
	public AirlineDTO updateById(int id, Airline airline) {
	Airline a=airlineDAO.updateById(id, airline);
	return new ModelMapper().map(a,AirlineDTO.class );
	
	}

}
