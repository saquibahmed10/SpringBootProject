package com.ars;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import javax.swing.JOptionPane;

import com.ars.entity.Airline;
import com.ars.entity.Flight;
import com.ars.entity.Passenger;
import com.ars.entity.TicketGenerationPdf;
import com.ars.model.PassengerDTO;
import com.ars.model.TicketBookingDTO;
import com.ars.service.AirlineService;
import com.ars.service.FlightService;
import com.ars.service.PassengerService;
import com.ars.service.TicketService;
import com.ars.serviceimpl.AirlineServiceImpl;
import com.ars.serviceimpl.FlightServiceImpl;
import com.ars.serviceimpl.PassengerServiceImpl;
import com.ars.serviceimpl.TicketServiceImpl;

public class CrudOperation {

	static PassengerService pservice=new PassengerServiceImpl();
	static FlightService fService=new FlightServiceImpl();
	static AirlineService aService=new AirlineServiceImpl();
	static TicketService tService=new TicketServiceImpl();
	
	//this method is responsible to perform crud  operation of instructor
		public static void crudPassenger()
		{
			String xx;
			while(true) {
			System.out.println("============================================================================");
	System.out.println( "Press r. for read Passenger details\n Press u.for update Passenger details\n Press d.for delete Passenger details\n"
			+ " Press q for quit");
	System.out.println("============================================================================");
	 xx=JOptionPane.showInputDialog("Enter choice","Type here");

	 switch(xx) {
	 

	 case "r":
	
		try {

		
			PassengerDTO pDto=pservice.getPassengerById(Integer.parseInt(JOptionPane.showInputDialog("Enter id", "type here")));
			System.out.println("Passenger details: ");
			System.out.println("Id: "+pDto.getId());
			System.out.println("Name: "+pDto.getName());
	        System.out.println("Ph. No: "+pDto.getPhno());
	        System.out.println("Email: "+pDto.getEmail());
		}
		catch (Exception e) {
			System.out.println(e);
		}
		
	break;
		
	 case "u":

		Passenger passenger=new Passenger();
		passenger.setName("nilanjan dasgupta");
		passenger.setEmail("nilanjan.d@gamil.com");
		passenger.setPhno("8890234123");
		passenger.setUserName("nilanjanD");
		passenger.setPassword("nilD12");
		
		PassengerDTO upPass=pservice.updatePassenger(Integer.parseInt(JOptionPane.showInputDialog("enter id to update", "type here")),
				passenger);
		System.out.println("Passenger updated successfully");
	break;	

	 case "d":
		pservice.deletePassenger(Integer.parseInt(JOptionPane.showInputDialog("enter id to update", "type here")));
	break;

	 case "q":
		 crudOpeartion();
		 break;

	 }//end of switch
			}
		} //crud passenger
		
		
		//this method is responsible to  perform crud operation of flight
		public static void crudFlight()
		{
			String in;
			while(true) {
			System.out.println("============================================================================");
		System.out.println("Press c. for add Flight details\n"
				+ "Press r. for flight details\n Press u.for update flight details\n Press d.for delete flight details\n"
				+ " Press q for quit ");
		System.out.println("============================================================================");
		in=JOptionPane.showInputDialog("Enter choice","Type here");
		
		switch(in) {
		case "c":
		         Flight flight3=new Flight();
		         flight3.setAvailableSeats(100);
		         flight3.setTotalSeats(150);
		         flight3.setTravellerClass("economy");
		         flight3.setTime("13:26");
		         LocalDate custDate1 = LocalDate.of(2022, 10, 20);
		         flight3.setDate(custDate1);
		         flight3.setSource("kolkata");
		         flight3.setDestination("mumbai");
		         fService.saveFlight(flight3);
		         System.out.println("Flight added successfully!!");
	       break;
		

//		case "r":
//			
//	   break;
//		case "u":
//		
//	   
//	  break;
//			
//		case "d":
//			
//	   
//		
//	   break;
		case "q":
			AdminOpeartion();
			break;
			default:System.out.println("wrong input");
//		
	}//switch 
		}
} //crud flight
	
		
//this method is responsible to assign flights to airline		
public static void assignAirlineToFlight()
{
	
	aService.assignAirlineToFlight(3, 2);
	System.out.println("flight assign to airline successfully");
}
		
	public static void crudAirline()
	{
	
		
		String in;
		while(true) {
		System.out.println("============================================================================");
	System.out.println("Press c. for add Airline details\n"
			+ "Press r. for get AIrline details\n Press u.for update Airline details\n Press d.for delete Airline details\n"
			+ " Press q for quit ");
	System.out.println("============================================================================");
	in=JOptionPane.showInputDialog("Enter choice","Type here");
	
	switch(in) {
	
	case "c":
		Airline airline2=new Airline();
		airline2.setAirlineName("spicejet");
		airline2.setFare(4000.78f);
	    aService.saveAirline(airline2);
	    System.out.println("Airline saved succeessfully");
	    break;
	    
	case "u":
		Airline airline3=new Airline();
		airline3.setAirlineName("indigo");
		airline3.setFare(5000.78f);
	    aService.updateById(1, airline3);
	    System.out.println("airline updated successfully");
	    break;
	
	case "q":
		AdminOpeartion();
		break;
	}//end of switch
	}//end of while
	}//end of method
		

public static void 	bookFlight()
{
	List<Flight> flights=fService.checkFlight(JOptionPane.showInputDialog("Enter From","Type here"),
			JOptionPane.showInputDialog("Enter To","Type here"),
			LocalDate.parse(JOptionPane.showInputDialog("Enter Date","Type here")));
	System.out.println("Flight Id \t Airline Name \t From \t To \t Fare \t Timing \tDate ");
	for(Flight flight: flights)
	{
		System.out.println(flight.getFlight_id() +"\t\t"+ flight.getAirline().getAirlineName()+"\t"+ 
	flight.getSource()+"\t"+ flight.getDestination()+"\t"+flight.getAirline().getFare()+"\t"+
			flight.getTime()+"\t"+flight.getDate());
	}
		System.out.println("For booking press Yes");
		String choice=JOptionPane.showInputDialog("Enter Here","Type here");
		if(choice.equalsIgnoreCase("yes"))
		{
			int flight_id=Integer.parseInt(JOptionPane.showInputDialog("Enter Flight ID","Type here"));
			int no_of_passenger=Integer.parseInt(JOptionPane.showInputDialog("Enter total passenger","Type here"));
		    LocalDate date=LocalDate.parse(JOptionPane.showInputDialog("Enter Date","Type here"));
		    String pEmail=JOptionPane.showInputDialog("Enter Passenger Email","Type here");
		    String airName=JOptionPane.showInputDialog("Enter AirLine Name","Type here");
		    TicketBookingDTO ticketDTO=tService.bookFlight(flight_id, no_of_passenger, date, pEmail, airName);
		    System.out.println("your booking has done successfully");
		    TicketGenerationPdf.TicketGeneration(ticketDTO);
		
	}
}
	
	
	
		//sub menu to choose menu
		public static void crudOpeartion()
		{

	    	int input;
	    	while(true) {
	    		System.out.println("============================================================================");
	    	System.out.println("Press 1. for Passenger details\n Press 2. for check flights\n"
	    			+ "Press 3. for book flight\n Press 4. for quit");
	         input=Integer.parseInt(JOptionPane.showInputDialog("Enter choice","Type here"));
	    	System.out.println("============================================================================");
	    	
	    	switch(input){
	    		
	    	case 1:
	    	crudPassenger();
	           break;
	    	
	    	case 2:
           //  fService.checkFlight(null, null);
	    		break;
//	    		
	    	case 3:
	    		bookFlight();
	    		break;
	    	case 4:
	    		App.mainMenu();
	    		break;
	    		
	    	}
	    	}
		}
	    	public static void AdminOpeartion()
			{

		    	int input;
		    	while(true) {
		    		System.out.println("============================================================================");
		    	System.out.println("Press 1. for Flight details\n Press 2. for airline details\n"
		    			+ "Press 3. for add flight to airlines\n Press 4. for quit");
		         input=Integer.parseInt(JOptionPane.showInputDialog("Enter choice","Type here"));
		    	System.out.println("============================================================================");
		    	
		    	switch(input){
		    		
		    	case 1:
		    	crudFlight();
		           break;
		    	
		    	case 2:
		    	crudAirline();
		    		break;
    		
		    	case 3:
		    		assignAirlineToFlight();
		    		break;
		    	case 4:
		    		App.mainMenu();
		    		break;
		    		
	    	}
		    	}	
		    	
		}
}
