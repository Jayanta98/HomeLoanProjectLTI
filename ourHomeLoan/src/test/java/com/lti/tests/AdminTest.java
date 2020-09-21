package com.lti.tests;

import org.junit.Test;

import com.lti.entity.Admin;
import com.lti.service.AdminService;

public class AdminTest {

	@Test
	public void adminRegister() {
		Admin admin = new Admin();
		admin.setFirstName("Jayanta");
		admin.setLastName("Ghosh");
		admin.setEmail("jayanta@gmail.com");
		admin.setUsername("Jay");
		admin.setPassword("Jg123");
		
		AdminService as = new AdminService();
		
		System.out.println(as.registerAdmin(admin));
	}
	
	@Test
	public void loginAdmin() {
		AdminService as = new AdminService();
		
		Admin ad = as.adminLogin("Jay", "Jg123");
		System.out.println(ad.getFirstName() + "\t" + ad.getLastName());
	}
}

