package com.ars.daoimpl;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ars.config.HibernateUtil;
import com.ars.dao.AirlineDAO;
import com.ars.entity.Airline;
import com.ars.entity.Flight;

public class AirlineDAOImpl implements AirlineDAO{
	private static final Logger logger=LoggerFactory.getLogger(AirlineDAOImpl.class);
	@Override
	public void saveAirline(Airline airline) {
		try(Session session=HibernateUtil.getSession())
		{
			//adding new airline details
			session.beginTransaction();
			session.save(airline);
			
			//java object saved to database
			session.getTransaction().commit();
			
			//clear the session
			session.clear();
		}
		catch (HibernateException e) {
			System.out.println("hibernate exception is: "+ e);
		}
			
		catch (Exception e) {
			System.out.println("exception is: "+ e);
		}	
		
	}

	@Override
	public void assignAirlineToFlight(int flightId, int airId) {
		try(Session session=HibernateUtil.getSession())
		{
		Flight flight=(Flight)session.get(Flight.class, flightId);
		Airline airline =(Airline)session.load(Airline.class, airId);
		
		List<Flight> flights=new ArrayList<>();
		flights.add(flight);
		
		airline.setFlights(flights);
		flight.setAirline(airline);
		
		session.beginTransaction();
		session.saveOrUpdate(airline);
		
		session.getTransaction().commit();
		}
		catch (HibernateException e) {
			System.out.println("hibernate exception is: "+ e);
		}
			
		catch (Exception e) {
			System.out.println("exception is: "+ e);
		}
	}

	@Override
	public Airline getAirlineByName(String name) {
	try(Session session=HibernateUtil.getSession()){
		String query="from Airline a where a.airlineName=:an";
        Query q =session.createQuery(query);
        q.setParameter("an", name);
         Airline airline=(Airline) q.uniqueResult();
         return airline;
	}
	catch (HibernateException e) {
		System.out.println("hibernate exception is: "+ e);
	}
		
	catch (Exception e) {
		System.out.println("exception is: "+ e);
	}
		return null;
	}

	@Override
	public Airline updateById(int id, Airline airline) {
		try(Session session=HibernateUtil.getSession()){
			Airline air=(Airline)session.load(Airline.class, id);
			air.setAirlineName(airline.getAirlineName());
			air.setFare(airline.getFare());
			session.beginTransaction();
			session.saveOrUpdate(air);
			logger.info("Airline updated successfully: "+ air.toString()+" at "+ new java.util.Date());
			session.getTransaction().commit();
			return air;
		}
		catch (HibernateException e) {
			System.out.println("hibernate exception is: "+ e);
		}
			
		catch (Exception e) {
			System.out.println("exception is: "+ e);
		}
		return null;
	}
  
}
