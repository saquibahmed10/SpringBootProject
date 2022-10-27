package com.ars.daoimpl;

import javax.swing.JOptionPane;

import org.hibernate.Session;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.ars.config.HibernateUtil;
import com.ars.dao.AdminDAO;
import com.ars.entity.Admin;
import com.ars.entity.Passenger;

public class AdminDAOImpl implements AdminDAO {
	 private static final Logger logger=LoggerFactory.getLogger(AdminDAOImpl.class);
	@Override
	public void registerAdmin(Admin admin) {
		Session session=HibernateUtil.getSession();
		session.beginTransaction();
		session.save(admin);
		session.getTransaction().commit();
		logger.info("admin registered successfully: "+ admin.toString()+" at "+ new java.util.Date());
		session.close();
		
		
	}

	@Override
	public boolean loginAdmin(String userName, String password) {
		Session session=HibernateUtil.getSession();
		Admin admin=(Admin)session.get(Admin.class,
				Integer.parseInt(JOptionPane.showInputDialog("enter Id:","Type here")));
		
		if(admin.getUserName().equals(userName) && admin.getPassword().equals(password))	
		{
			return true;
			}
		else {
			return false;
		}
		
	}

}
