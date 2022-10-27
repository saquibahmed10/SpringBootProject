package com.ars.dao;

import com.ars.entity.Admin;

public interface AdminDAO {

	void registerAdmin(Admin admin);
	boolean loginAdmin(String userName,String password);
}
