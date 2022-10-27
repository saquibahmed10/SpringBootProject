package com.ars;

import static org.assertj.core.api.Assertions.assertThat;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

import java.util.Set;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.Transaction;
import org.junit.jupiter.api.AfterAll;
import org.junit.jupiter.api.AfterEach;
import org.junit.jupiter.api.BeforeAll;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;

import com.ars.config.HibernateUtil;
import com.ars.daoimpl.PassengerDAOImpl;
import com.ars.entity.Passenger;
import com.ars.model.PassengerDTO;
import com.ars.service.PassengerService;
import com.ars.serviceimpl.PassengerServiceImpl;

import jakarta.validation.ConstraintViolation;
import jakarta.validation.Validation;
import jakarta.validation.Validator;
import jakarta.validation.ValidatorFactory;

public class PassengerTest {

	private static Validator validator;
	PassengerService passengerService=new PassengerServiceImpl();
	
	private static SessionFactory sessionFactory;
	private Session session;
	
	@BeforeAll
	public static void setUp()
	{
		ValidatorFactory factory = Validation.buildDefaultValidatorFactory();
		validator = factory.getValidator();
		sessionFactory=HibernateUtil.getSessionFactory();
	}

	@BeforeEach
	public void OpenSession()
	{
		session=sessionFactory.openSession();
	}
	
	@AfterEach
	public void closeSession()
	{
		if(session!= null)
			session.close();
		System.out.println("Session closed");
	}
	
	@AfterAll
	public static void tearDown()
	{
		if(sessionFactory!=null)
			sessionFactory.close();
		System.out.println("Session factory closed");
	}
	
//	@Test
//	@DisplayName("Positive Test Case")
//	public void PassengerNotNull()
//	{
//		PassengerDTO passengerDTO=new PassengerDTO("p", "4567856789", "pallab@gamil.com");
//		
//		Set<ConstraintViolation<PassengerDTO>> constraintViolations =
//			      validator.validate( passengerDTO );
//		 //assertEquals( 1, constraintViolations.size() );
//		assertEquals("Name should be more than 2 characters", constraintViolations.iterator().next().getMessage());
//	}
//	
//	@Test
//	@DisplayName("Negative Test Case")
//	public void PassengerEmailTest()
//	{
//		PassengerDTO passengerDTO=new PassengerDTO("p", "4567856789", null);
//		Set<ConstraintViolation<PassengerDTO>> constraintViolations =
//			      validator.validate( passengerDTO );
//		assertEquals("Email Can Not Be Blank", constraintViolations.iterator().next().getMessage());
//	}
	
//	@Test
//	public void testSavePassenger()
//	{
//		System.out.println("..........Running TestSavePassenger.............");
//		Transaction tx=session.beginTransaction();
//		Passenger pass=Passenger.builder().name("priya").email("priya@gmail.com").
//				phno("9906453678").UserName("priya").password("priya12").role("user").build();
//		Integer i=(Integer) session.save(pass);
//		tx.commit();
//		assertThat(i>0).isTrue();
//		
//	}
//	
//	@Test
//	public void testUpdatePassenger()
//	{
//		System.out.println("..........Running TestUpdatePassenger.............");
//		Transaction tx=session.beginTransaction();
//		Passenger pass=Passenger.builder().name("shawain").email("shawin@gmail.com").
//				phno("9906478456").build();
//		session.save(pass);
//		pass.setName("shawin pradhan");
//		
//		assertThat(pass.getName()).isEqualTo("shawin pradhan");
//	}
	
	@Test
	public void testUpdatePassengerUsingService()
	{
		System.out.println("..........Running TestUpdatePassenger.............");
		Transaction tx=session.beginTransaction();
		Passenger p=new Passenger();
		p.setName("shawin pradhan");
		p.setEmail("shawin.p@gmail.com");
		p.setPhno("7895678923");
		PassengerDTO pdto=passengerService.updatePassenger(25, p);
		
		
		assertThat(pdto.getName()).isEqualTo("shawin pradhan");
	}
	
//	@Test
// 	 public void testdeletePassengerUsingService()
// 	   {
// 		 System.out.println(".........RunningTestDeletePassenger");
// 		 Transaction tx=session.beginTransaction();
// 		 passengerService.deletePassenger(3);
// 		 assertNull(passengerService.getPassengerById(3));
// 	   }
	
	
	
	
//	@Test
//	public void testReadPassenger() {
//		PassengerDTO pdto =passengerService.getPassengerById(2);
//		assertThat(pdto.getName()).isEqualTo("chandan");
//	}

	
	@Test
	 void testdeletePassengerUsingService()
	{
		System.out.println(".................Running TestDeletePassenger");
	
		passengerService.deletePassenger(9);		
		assertThrows(GlobalException.class, ()->passengerService.getPassengerById(9));
		
	}
}
