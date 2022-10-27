package com.ars.serviceimpl;

import org.modelmapper.ModelMapper;

import com.ars.dao.PassengerDAO;
import com.ars.daoimpl.PassengerDAOImpl;
import com.ars.entity.Passenger;
import com.ars.exception.GlobalException;
import com.ars.model.PassengerDTO;
import com.ars.service.PassengerService;

public class PassengerServiceImpl implements PassengerService{
    
	PassengerDAO passengerDAO=new PassengerDAOImpl();
	
	@Override
	public void savePassenger(Passenger passenger) {
		passengerDAO.savePassenger(passenger);
		
	}

	@Override
	public boolean login(String userName,String password) {
	
		return passengerDAO.login(userName,password);
	}

	@Override
	public PassengerDTO updatePassenger(int id, Passenger passenger) {
		Passenger p=passengerDAO.updatePassenger(id, passenger);
		return new ModelMapper().map(p, PassengerDTO.class); //converting entity to DTO
	}

	@Override
	public PassengerDTO getPassengerById(int id) throws GlobalException {
	
	Passenger passanger	=passengerDAO.getPassenger(id);
	if(passanger!=null)
	{
		return new ModelMapper().map(passanger, PassengerDTO.class);
	}
		throw new GlobalException("Passenger details not exist!!");
	}

	@Override
	public void deletePassenger(int id) {
		passengerDAO.deletePassenger(id);
		
	}

	
	
	
	
}
