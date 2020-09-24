package com.lti.tests;

import java.time.LocalDate;

import org.junit.Test;

import com.lti.dao.ApplicationDao;
import com.lti.dao.GenericDao;
import com.lti.entity.Account;
import com.lti.entity.Application;
import com.lti.entity.Document;
import com.lti.entity.Income;
import com.lti.entity.Loan;
import com.lti.entity.Property;

public class ApplicationTest {

	//Working fine
	@Test
	public void addApplication() {
		//Object Definition
		Application a = new Application();
		Property p= new Property();
		
		Income i = new Income();
		Loan l=new Loan();
		Document d= new Document();
		
		//Application table 
		a.setFirstname("Ram");
		a.setMiddlename("Kr");
		a.setLastname("Ghosh");
		a.setEmail("rj@gmail.com");
		a.setPassword("123456");
		a.setConfirmPassword("123456");
		a.setPhoneNo("9988774455");
		a.setDateOfBirth(LocalDate.now());
		a.setGender("Male");
		a.setNationality("Indian");
		a.setAadharNo("11223344");
		a.setPanNo("456321");


		//not taking input from user
		a.setApplicationStatus("Pending");
		a.setDateOfAppointment(LocalDate.now().plusDays(5));
		
		
		//Property Table
		p.setPropertyName("Ghar");
		p.setPropertyLocation("Pune");
		p.setEstimatedAmount(2500000);
		
		p.setApplication(a);//setting Application_Id in Property Table OtherWise you will get Application_Id=Null
		
		//Income Table
		i.setTypeOfEmployement("Software Engineer");
		i.setOrganizationType("Private Sector");
		i.setEmployerName("LTI");
		i.setRetirementAge(60);
		
		i.setApplication(a);//setting Application_Id in Income Table OtherWise you will get Application_Id=Null
		
		//Loan Table
	    l.setMaxLoanAmount(2000000);
		l.setInterestRate(10);
		l.setLoanAmount(120000);
		l.setTenure(10);
		l.setEmi(2000);
		l.setStartDate(LocalDate.of(2020, 8, 1));
		l.setEndDate(LocalDate.of(2030, 8, 1));	
		l.setLoanStatus("Not Approved");
		
		l.setApplication(a);//setting Application_Id in Loan Table OtherWise you will get Application_Id=Null
		
		//Document Table//extract location
		d.setPanCard("location");
		d.setVoterIdCard("location");
		d.setSalarySlip("location");
		d.setLOA("location");
		d.setNOCFromBuilder("location");
		d.setAgreementToSale("location");
		
		d.setApplication(a);//setting Application_Id in Document Table OtherWise you will get Application_Id=Null
		
		//Account Table// Account table should not be entered at addApplication time
		//It should be inserted by Admin 
		
	
		a.setProperty(p);
		a.setIncome(i);
		a.setLoan(l);
		a.setDocument(d);
		
		
		GenericDao dao = new GenericDao();
		dao.save(a);	
		

	}
	
	@Test
	public void customerLogin()//parenthesis will have values of email id and password 
	{
		//write the test code for login of customer by using email and password
		ApplicationDao dao = new ApplicationDao();
		Application applicant = dao.applicationLogin("jg@gmail.com", "123456");
		System.out.println(applicant.getFirstname()+" "+applicant.getMiddlename()+" "+applicant.getLastname());;
	}
	
	@Test
	public void seeAccount() {
		ApplicationDao as = new ApplicationDao();
		Account account =as.displayAccountDetails(101);
		System.out.println(account.getFirstName()+" "+account.getMiddleName()+" "+account.getLastName()); 
		System.out.println(account.getAccountType());
		System.out.println(account.getBranchName()+" "+account.getBranchCode());
		System.out.println(account.getAmount());
	}
	
	@Test
	public  void seeApplicationStatus() {
		ApplicationDao as = new ApplicationDao();
		
		String applicantstatus = as.applicationStatus(1005);
		System.out.println(applicantstatus);
	}

	
}
