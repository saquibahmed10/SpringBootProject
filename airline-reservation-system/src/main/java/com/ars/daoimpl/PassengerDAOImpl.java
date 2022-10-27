package com.ars.daoimpl;

import javax.persistence.PersistenceException;
import javax.swing.JOptionPane;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.query.Query;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ars.config.HibernateUtil;
import com.ars.dao.PassengerDAO;
import com.ars.entity.Passenger;

public class PassengerDAOImpl implements PassengerDAO{
	
 private static final Logger logger=LoggerFactory.getLogger(PassengerDAOImpl.class);
	@Override
	public void savePassenger(Passenger passenger) {
		try(Session session=HibernateUtil.getSession())
		{
			//adding new passenger details
			session.beginTransaction();
			session.save(passenger);
			
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
	public boolean login(String userName,String password) {
		Session session=HibernateUtil.getSession();
	Passenger p=(Passenger)session.get(Passenger.class,
			Integer.parseInt(JOptionPane.showInputDialog("enter Id:","Type here")));
	
	if(p.getUserName().equals(userName) && p.getPassword().equals(password))	
	{
		return true;
		}
	else {
		return false;
		 
	}
	}

	@Override
	public Passenger updatePassenger(int id, Passenger passenger) {
		try(Session session=HibernateUtil.getSession()){
		Passenger pass=(Passenger)session.load(Passenger.class, id);
		
		//update existing details with new one
		pass.setName(passenger.getName());
		pass.setEmail(passenger.getEmail());	
		pass.setPhno(passenger.getPhno());
		pass.setUserName(passenger.getUserName());
		pass.setPassword(passenger.getPassword());
		
		session.beginTransaction();
		session.saveOrUpdate(pass);
		session.getTransaction().commit();
		
		logger.info("passenger updated successfully: "+ pass.toString()+" at "+ new java.util.Date());
		return pass;// return passenger entity
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
	public Passenger getPassenger(int id) {
		try(Session session=HibernateUtil.getSession()){
		Passenger passenger=(Passenger)session.get(Passenger.class, id);
		logger.info("passenger detail fetched: "+passenger.toString()+" at "+ new java.util.Date());
		return passenger;
		
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
	public void deletePassenger(int id) throws PersistenceException {
		try(Session session=HibernateUtil.getSession()){
		Passenger passn=session.load(Passenger.class, id);
		
		session.beginTransaction();
		int input=JOptionPane.showConfirmDialog(null, "do you want to delete?",
				"select what you want to delete or not?",JOptionPane.YES_NO_OPTION);
			
		if(input==0)
		{
			session.delete(passn);
			JOptionPane.showMessageDialog(null, "Object is deleted!!!!");
		}
		else
		JOptionPane.showMessageDialog(null, "User wants to retain it!!!");
		
		session.getTransaction().commit();
		logger.info("passenger deleted successfully: "+ passn.toString()+" at "+ new java.util.Date());
		}catch (HibernateException e) {
			System.out.println("hibernate exception is: "+ e);
		}
			
		
		
		catch(PersistenceException e)
		   {
			throw new PersistenceException("you cannot delete your account as you have booking with us");
		   }
	}

	@Override
	public Passenger getPassengerByEmail(String email) {
		try(Session session=HibernateUtil.getSession()){
			String query="from Passenger p where p.email=:e";
		Query q=session.createQuery(query);
		q.setParameter("e", email);
		   Passenger p=(Passenger)q.uniqueResult();
		   return p;
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






