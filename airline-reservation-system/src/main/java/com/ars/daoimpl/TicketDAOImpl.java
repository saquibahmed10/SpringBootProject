package com.ars.daoimpl;

import java.time.LocalDate;

import org.hibernate.HibernateException;
import org.hibernate.Session;

import com.ars.config.HibernateUtil;
import com.ars.dao.TicketDAO;
import com.ars.entity.Airline;
import com.ars.entity.Flight;
import com.ars.entity.Passenger;
import com.ars.entity.TicketBooking;

public class TicketDAOImpl implements TicketDAO{


	@Override
	public TicketBooking bookFlight(Airline airline, Passenger p, LocalDate date, Flight f, int no_of_passenger,
			float total_fare, int available_seat) {
		try(Session session=HibernateUtil.getSession())
		   {
			  session.beginTransaction();
			
			  TicketBooking ticketBooking=new TicketBooking();
			  ticketBooking.setAId(airline);
			  ticketBooking.setDate(date);
			  ticketBooking.setFId(f);
			  ticketBooking.setNo_of_passenger(no_of_passenger);
			  ticketBooking.setPId(p);
			  ticketBooking.setTotalFare(total_fare);
			  session.save(ticketBooking);
			  f.setAvailableSeats(available_seat);
			  session.saveOrUpdate(f);
			  session.getTransaction().commit();
			 return ticketBooking;
			  
		   }catch (HibernateException e) {
				System.out.println("hibernate exception is: "+ e);
			}
				
			catch (Exception e) {
				System.out.println("exception is: "+ e);
			}
		return null;

	}

}
