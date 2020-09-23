package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Account;
import com.lti.entity.Application;
import com.lti.exception.ApplicationServiceException;


	public class ApplicationDao extends GenericDao {
		
		
		
		//Checking is applicationWith the appNo Exist or not
		public boolean isApplicationExists(String email) {
			EntityManagerFactory emf = null;
			EntityManager em = null;
			
			try {
				emf = Persistence.createEntityManagerFactory("ourHomeLoan");
				em = emf.createEntityManager();
				
				String jpql = "select count(a.id) from Application a where a.email =:email";
				Query q = em.createQuery(jpql);
				q.setParameter("email", email);
				Long count = (Long) q.getSingleResult();
				if(count == 1)
					return true;
				else
					return false;
				
			}
			finally {
				em.close();
				emf.close();
			}
		}
		
		public int getApplicationId(String email, String password) {
			EntityManagerFactory emf = null;
			EntityManager em = null;
			
			try {
				emf = Persistence.createEntityManagerFactory("ourHomeLoan");
				em = emf.createEntityManager();
				
				String jpql = "select a.id from Admin a where a.email =:email and a.password =:password";
				Query q = em.createQuery(jpql);
				q.setParameter("email", email);
				q.setParameter("password", password);
				Integer id = (Integer) q.getSingleResult();
				return id;
				
			}
			finally {
				em.close();
				emf.close();
			}
		}
		
		public Application applicationLogin(String email, String password) {
			GenericDao dao = new GenericDao();
			boolean adminExists = isApplicationExists(email);
			
			if(adminExists) {
				try {
					int id = getApplicationId(email, password);
					Application applicant = dao.fetchById(Application.class, id);
					return applicant;
				}
				catch(Exception e) {
					throw new ApplicationServiceException("Incorrect email/password");
				}
			}
			else {
				throw new ApplicationServiceException("Account not available");
			}
		}
			
		//returns Application status as string to ApplicationDao
		public String applicationStatus(int appNo) {
			EntityManagerFactory emf = null;
			EntityManager em = null;
			
			try {
				emf = Persistence.createEntityManagerFactory("ourHomeLoan");
				em = emf.createEntityManager();
				
				String jpql = "select a.applicationstatus from Application a where a.id =: appno";
				Query q = em.createQuery(jpql);
				q.setParameter("appno", appNo);
				String applicationstatus = (String) q.getSingleResult();
				return applicationstatus;
				
			}
			finally {
				em.close();
				emf.close();
			}
		}
			//for Account details
			public Account  displayAccountDetails(int accountNo) {
				EntityManagerFactory emf = null;
				EntityManager em = null;
				
				try {
					emf = Persistence.createEntityManagerFactory("ourHomeLoan");
					em = emf.createEntityManager();
					
					String jpql = "select a from Account a where a.accountno =: accountNo";
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
	
}
