package com.lti.tests;

import java.util.ArrayList;
import java.util.List;

import org.junit.Test;

import com.lti.dao.AdminApplicationPropertyDao;
import com.lti.entity.Application;
import com.lti.entity.Property;

public class AdminApplicationPropertyDaoTest {
	
	
	
	@Test
	public void getListOfApplicants(){
		
		List<Application> applist = new ArrayList<>();
		AdminApplicationPropertyDao dao = new AdminApplicationPropertyDao();
		applist.addAll(dao.getApplicants());
		for(Application a:applist) {
			System.out.println("Name: "+a.getFirstname()+" "+a.getLastname());
			System.out.println("Date of Appointment: "+a.getDateOfAppointment());
			System.out.println("Application Status: "+a.getApplicationStatus());
		}
	}
	
	//list of property	
		@Test
		public void getListOfProperty(){
			
			List<Property> propertylist = new ArrayList<>();
			AdminApplicationPropertyDao dao = new AdminApplicationPropertyDao();
			propertylist.addAll(dao.getProperty());
			for(Property p:propertylist) {
				System.out.println("Property Name"+p.getPropertyName());
				System.out.println("Property Location"+p.getPropertyLocation());
				System.out.println("Property Estimated Amount"+p.getEstimatedAmount());
			}
		}
		
		//ApplicationObject
		@Test
		public void getApplicationbyId() {
			
			Application a =new Application();
			AdminApplicationPropertyDao dao = new AdminApplicationPropertyDao();
			a=dao.applicationDetailByApplicationId(1008);//put according to sqlplus
			System.out.println(a.getFirstname());//generated tostring in Application	
		}
		
		//Property Object
		@Test
		public void getPropertybyId() {
			
			Property p =new Property();
			AdminApplicationPropertyDao dao = new AdminApplicationPropertyDao();
			p=dao.propertyDetailByApplicationId(1008);//put according to sqlplus
			System.out.println(p.getPropertyName());//generated tostring in Property	
		}

}
