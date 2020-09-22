package com.lti.tests;

import org.junit.Test;

import com.lti.dao.AdminDao;
import com.lti.entity.Admin;

public class AdminTest {

	@Test
	public void adminRegister() {
		Admin admin = new Admin();
		admin.setFirstName("Jayanta");
		admin.setLastName("Ghosh");
		admin.setEmail("jayanta@gmail.com");
		admin.setUsername("Jay");
		admin.setPassword("Jg123");
		
		AdminDao ad = new AdminDao();
		
		System.out.println(ad.registerAdmin(admin));
	}
	
	@Test
	public void loginAdmin() {
		AdminDao ad = new AdminDao();
		
		Admin admin = ad.adminLogin("Jay", "Jg123");
		System.out.println(admin.getFirstName() + "\t" + admin.getLastName());
	}
}

