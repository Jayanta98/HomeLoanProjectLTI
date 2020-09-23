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
		Account ac= new Account();
		Income i = new Income();
		Loan l=new Loan();
		Document d= new Document();
		
		//Application table 
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
		

		//not taking input from user
		a.setApplicationStatus("Pending");
		a.setDateOfAppointment(LocalDate.now().plusDays(5));
		
		//Property Table
		p.setPropertyName("Ghar");
		p.setPropertyLocation("Pune");
		p.setEstimatedAmount(2500000);
		
		//Income Table
		i.setTypeOfEmployement("Software Engineer");
		i.setOrganizationType("Private Sector");
		i.setEmployerName("LTI");
		i.setRetirementAge(60);
		
		//Loan Table
	    l.setMaxLoanAmount(2000000);
		l.setInterestRate(10);
		l.setLoanAmount(120000);
		l.setTenure(10);
		l.setEmi(2000);
		l.setStartDate(LocalDate.of(2020, 8, 1));
		l.setEndDate(LocalDate.of(2030, 8, 1));	
		
		//Document Table//extract location
		d.setPanCard("location");
		d.setVoterIdCard("location");
		d.setSalarySlip("location");
		d.setLOA("location");
		d.setNOCFromBuilder("location");
		d.setAgreementToSale("location");
		
		//Account Table//has issues
		ac.setFirstName(ac.getFirstName());
		ac.setMiddleName(a.getMiddlename());
		ac.setLastName(a.getLastname());
		ac.setAccountType("savings");
		ac.setAmount(50000);
		ac.setIfscCode("SBIN10002");
		ac.setBranchCode("SBI879");
		ac.setBranchName("Mahape");
		
		
		//passing data through object to other tables
		a.setProperty(p);
		a.setIncome(i);
		a.setLoan(l);
		a.setDocument(d);
		a.setAccount(ac);
		
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
		
		String applicantstatus = as.applicationStatus(101);
		System.out.println(applicantstatus);
	}

	
}
