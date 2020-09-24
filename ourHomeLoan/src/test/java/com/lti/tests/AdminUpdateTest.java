package com.lti.tests;

import java.time.LocalDate;
import java.util.List;

import org.junit.Test;

import com.lti.dao.AdminUpdateActivityDao;
import com.lti.dao.ApplicationDao;
import com.lti.dao.GenericDao;
import com.lti.entity.Account;
import com.lti.entity.Application;

public class AdminUpdateTest {
	
	
	
	@Test//Working Fine
	public void insertAccountByAdminTest()
	{
		AdminUpdateActivityDao adminDao= new AdminUpdateActivityDao();
		
		Account ac= new Account();
		ac.setFirstName("Ram");
		ac.setMiddleName("Kr");
		ac.setLastName("Ghosh");
		ac.setAccountType("savings");
		ac.setAmount(50000);
		ac.setIfscCode("SBIN10002");
		ac.setBranchCode("SBI879");
		ac.setBranchName("Mahape");
		
		GenericDao dao = new GenericDao();
		int applicationId=10020;
		Application application = dao.fetchById(Application.class, applicationId);
		
		ac.setApplication(application);
		
		adminDao.insertAccountDetailsByAdmin(ac);
		
	}
	
	
	//AccountDetails for a particular accNo Seen by Admin
	@Test
	public void seeAccountByAdminTest() {
		AdminUpdateActivityDao adminDao = new AdminUpdateActivityDao();
		Account account = adminDao.displayAccountDetailsByAdmin(1005);
		
		System.out.println(account.getFirstName()+" "+account.getMiddleName()+" "+account.getLastName()); 
		System.out.println(account.getAccountType());
		System.out.println(account.getBranchName()+" "+account.getBranchCode());
		System.out.println(account.getAmount());
	}
	
	
	//AccountDetails for a particular accNo Seen by Admin
	@Test
	public void seeFullAccountTableByAdminTest() {
		AdminUpdateActivityDao adminDao = new AdminUpdateActivityDao();
		List<Account> listofAccount = adminDao.displayFullAccountTableByAdmin();
		for(Account account:listofAccount)
		{
		System.out.println(account.getFirstName()+" "+account.getMiddleName()+" "+account.getLastName()); 
		System.out.println(account.getAccountType());
		System.out.println(account.getBranchName()+" "+account.getBranchCode());
		System.out.println(account.getAmount());
		}
	}
	
	
	
	
	
	
	//LoanTableUpdateByAdmin
	@Test
	public void loanTableUpdateByAdminTest()
	{
		AdminUpdateActivityDao adminDao = new AdminUpdateActivityDao();
		adminDao.updateLoanDetailsByAdmin(1006, 1500.0, LocalDate.now(), LocalDate.now().plusMonths(6));
	}
	
	@Test //Working Fine
	public void statusChangeByAdminTest()
	{
		AdminUpdateActivityDao adminUpdateDao = new AdminUpdateActivityDao();
		adminUpdateDao.updateApplicationStatus(1006, "Approved");
	}

}
