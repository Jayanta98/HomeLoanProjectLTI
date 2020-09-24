package com.lti.dao;

import java.time.LocalDate;
import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Account;

public class AdminUpdateActivityDao extends GenericDao {
	
	//Update Loan Table By Admin
	//Update LoanStatus By Admin
	
	public void updateLoanDetailsByAdmin(int appNo,double emi,LocalDate startDate,LocalDate endDate)
	{
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			String jpql = "update Loan l set l.emi =: emi,l.startDate=:startDate,l.endDate=:endDate  where l.application.applicationId=:appNo";
			Query q = em.createQuery(jpql);
			
			
			q.setParameter("emi",emi );
			q.setParameter("startDate",startDate );
			q.setParameter("endDate",endDate );
			q.setParameter("appNo", appNo);
		
		
			 q.executeUpdate();
			 tx.commit();
			
			
		}
		finally {
			em.close();
			emf.close();
		}
	}

	
	
	
	
	//Inserting Account Details For Particular Application By Admin
	public void insertAccountDetailsByAdmin( Account acc)
	{
			GenericDao dao = new GenericDao();
			dao.save(acc);

	}
	
	//one Account details  Seen by Admin
	
	public Account  displayAccountDetailsByAdmin(int accountNo) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			
			String jpql = "select a from Account a where a.accountNo =: accountNo";
			Query q = em.createQuery(jpql);
			q.setParameter("accountNo", accountNo);
			Account a = (Account) q.getSingleResult();
			return a;
			
		}
		finally {
			em.close();
			emf.close();
		}
}

	
	//Full Account Table Seen by Admin
	
	public List<Account>  displayFullAccountTableByAdmin() {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			
			String jpql = "select a from Account a";
			Query q = em.createQuery(jpql);
			List<Account> listofAccount = q.getResultList();
			//List<Account> listofAccount =  (List<Account>) q.getSingleResult();
			return listofAccount;
			
		}
		finally {
			em.close();
			emf.close();
		}
}
	
	
	//Status Update by admin from pending to 
	public void updateApplicationStatus(int appNo,String newStatus)
	{
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			
			tx.begin();
			String jpql = "update Application a set a.applicationStatus =: newStatus where a.applicationId=:appNo";
			Query q = em.createQuery(jpql);
			
			q.setParameter("newStatus",newStatus );
			q.setParameter("appNo", appNo);
		
		
			 q.executeUpdate();
			 tx.commit();
			
			
		}
		finally {
			em.close();
			emf.close();
		}
	}

}