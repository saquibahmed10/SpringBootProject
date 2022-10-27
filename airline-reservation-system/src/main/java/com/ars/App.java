package com.ars;

import java.util.Scanner;

import javax.swing.JOptionPane;

import com.ars.entity.Admin;
import com.ars.entity.Passenger;
import com.ars.service.AdminService;
import com.ars.service.PassengerService;
import com.ars.serviceimpl.AdminServiceImpl;
import com.ars.serviceimpl.PassengerServiceImpl;

/**
 * Hello world!
 *
 */
public class App 
{
	
    public static void main( String[] args )
    {
    	
      mainMenu();
    }
    
    public static void mainMenu()
    {
    	System.out.println("Press A for Admin\nPress U for Passenger\n Press Q for exit");
        String choice=JOptionPane.showInputDialog("Enter choice","Type here");
       
         switch(choice)
         {
         case "A": mainAdmin();
         break;
         
         case "U": mainUser();
         break;
         
         case "Q": System.exit(0);
         }	
    }
    
    public static void mainAdmin()
    {
              AdminService aService=new AdminServiceImpl();
    	
    	 String choice;
    	   while(true) {
    	    	System.out.println("Press R for Registration\nPress L for Login\n Press Q for exit");
    	        choice=JOptionPane.showInputDialog("Enter choice","Type here");
    	      
    	        switch(choice)
    	        {
    	        
    	        case "R":
    	       
    		        Admin admin=new Admin();
    		        admin.setAName("ram");
    		       admin.setEmail("ram@gmail.com");
    		       admin.setUserName("admin");
    		       admin.setPassword("admin123");
    		       admin.setRole("admin");
    		        
    		       aService.registerAdmin(admin);
    		       
    		        System.out.println("Admin Registration has done successfully");
    		        break;
    		        
    	        case "L":
    	        	boolean status=aService.loginAdmin(JOptionPane.showInputDialog("Enter UserName","Type here"),
    	        			JOptionPane.showInputDialog("Enter password","Type here"));
    	        	if(status==true)
    	        		CrudOperation.AdminOpeartion();
    	        	else
    	        		System.out.println("Invalid Credentials!!");
    	        	System.exit(0);
    	        	break;
    	        	
    	        case "Q":
    	        	mainMenu();
    	        }
    	       }
    }
    
    public static void mainUser()
    {
     PassengerService pservice=new PassengerServiceImpl();
    String choice;
   while(true) {
    	System.out.println("Press R for Registration\nPress L for Login\n Press Q for exit");
        choice=JOptionPane.showInputDialog("Enter choice","Type here");
      
        switch(choice)
        {
        
        case "R":
        	Passenger passenger1=new Passenger();
	        passenger1.setName("nilanjan");
	        passenger1.setEmail("nilanjan@gmail.com");
	        passenger1.setPhno("9903244889");
	        passenger1.setUserName("nil");
	        passenger1.setPassword("nil123");
	        passenger1.setRole("user");
	        
	        //for save passenger,invoking savePassenger() method from service class
	        pservice.savePassenger(passenger1);
	        
	        System.out.println("passenger Registration has done successfully");
	        break;
	        
        case "L":
        	boolean status=pservice.login(JOptionPane.showInputDialog("Enter UserName","Type here"),
        			JOptionPane.showInputDialog("Enter password","Type here"));
        	if(status==true)
        		CrudOperation.crudOpeartion();
        	else
        		System.out.println("Invalid Credentials!!");
        	System.exit(0);
        	break;
        	
        case "Q":
        	mainMenu();
        }
       }
    }
}
