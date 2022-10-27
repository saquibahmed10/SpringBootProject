package com.ars.serviceimpl;

import com.ars.dao.AdminDAO;
import com.ars.daoimpl.AdminDAOImpl;
import com.ars.entity.Admin;
import com.ars.service.AdminService;


public class AdminServiceImpl implements AdminService{

	AdminDAO aDao=new AdminDAOImpl();
	
	@Override
	public void registerAdmin(Admin admin) {
		aDao.registerAdmin(admin);
	}

	@Override
	public boolean loginAdmin(String userName, String password) {
		return aDao.loginAdmin(userName, password);
		
	}

}
