package com.lti.tests;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.dao.ApplicationDao;
import com.lti.dao.GenericDao;
import com.lti.entity.Admin;
import com.lti.entity.Application;



public class ApplicationTest {

	//Working fine
	@Test
	public void addApplication() {
		Application a = new Application();
		
		a.setFirstname("Palash");
		a.setMiddlename("Kr");
		a.setLastname("Ghosh");
		a.setEmail("jg@gmail.com");
		a.setPassword("123456");
		a.setConfirmPassword("123456");
		a.setPhoneNo("9988774455");
		a.setDateOfBirth(LocalDate.now());
		a.setGender("Male");
		a.setNationality("Indian");
		a.setAadharNo("11223344");
		a.setPanNo("456321");
		
		a.setApplicationStatus("Pending");
		a.setDateOfAppointment(LocalDate.now().plusDays(5));
		
		GenericDao dao = new GenericDao();
		
		dao.save(a);	
		

	}
	
	@Test
	public void customerLogin()
	{
		//write the test code for login of customer by using email and password
	}
	

	
}
