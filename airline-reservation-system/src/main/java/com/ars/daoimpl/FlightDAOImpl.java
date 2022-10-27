package com.ars.daoimpl;

import java.time.LocalDate;
import java.util.List;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;

import com.ars.config.HibernateUtil;
import com.ars.dao.FlightDAO;
import com.ars.entity.Flight;

public class FlightDAOImpl implements FlightDAO{

	@Override
	public void saveFlight(Flight flight) {
		try(Session session=HibernateUtil.getSession())
		{
			//adding new flight details
			session.beginTransaction();
			session.save(flight);
			
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
	public Flight updateFlight(int id, Flight flight) {
		
		return null;
	}

	@Override
	public Flight getFlight(int id) {
		try(Session session=HibernateUtil.getSession())
		{
		Flight flight =(Flight)session.get(Flight.class, id);
		return flight;
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
	public void deleteFlight(int id) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public List<Flight> checkFlight(String from, String to,LocalDate date) {
	        try(Session session=HibernateUtil.getSession())
	        {
	        	String q="from Flight as f where f.source=:s and f.destination=:d and f.date=:da";
	        	Query query=session.createQuery(q);
	        	query.setParameter("s", from);
	        	query.setParameter("d", to);
	        	query.setParameter("da", date);
	        	List<Flight> flights=query.list();
	        	return flights;
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
