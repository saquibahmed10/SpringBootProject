package com.ars.service;

import com.ars.entity.Admin;

public interface AdminService {
	void registerAdmin(Admin admin);
	boolean loginAdmin(String userName,String password);
}
