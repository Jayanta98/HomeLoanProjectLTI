package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Application;
import com.lti.entity.Document;
import com.lti.entity.Income;
import com.lti.entity.Loan;

public class AdminIncomeLoanDocViewDao {

	public List<Income> showIncomeDetails() {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			
			String jpql = "select i from Income i";
			Query q = em.createQuery(jpql);
			List<Income> list = q.getResultList();
			
			return list;
			
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	public Income searchIncomeDetailsByApplicationId(int appNo) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			
			String jpql = "select i from Income i join i.application a where a.applicationId = :appId";
			Query q = em.createQuery(jpql);
			q.setParameter("appId", appNo);
			Income income = (Income) q.getSingleResult();
			
			return income;
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	public List<Loan> showLoanDetails() {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			
			String jpql = "select l from Loan l";
			Query q = em.createQuery(jpql);
			List<Loan> list = q.getResultList();
			
			return list;
			
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	public Loan searchLoanDetailsByApplicationId(int appNo) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			
			String jpql = "select l from Loan l join l.application a where a.applicationId = :appId";
			Query q = em.createQuery(jpql);
			q.setParameter("appId", appNo);
			Loan loan = (Loan) q.getSingleResult();
			
			return loan;
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	public List<Document> showDocumentDetails() {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			
			String jpql = "select d from Document d";
			Query q = em.createQuery(jpql);
			List<Document> list = q.getResultList();
			
			return list;
			
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	public Document searchDocumentDetailsByApplicationId(int appNo) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			
			String jpql = "select d from Document d join d.application a where a.applicationId = :appId";
			Query q = em.createQuery(jpql);
			q.setParameter("appId", appNo);
			Document docs = (Document) q.getSingleResult();
			
			return docs;
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	public boolean checkLoanStatus(int appNo) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			
			String jpql = "select l from Loan l join l.application a where a.applicationId = :appId";
			Query q = em.createQuery(jpql);
			q.setParameter("appId", appNo);
			Loan loan = (Loan) q.getSingleResult();
			if(loan.getLoanStatus().equals("Not Approved"))
				return true;
			else
				return false;
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	public boolean isEligibleToApply(String aadharNo) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			
			boolean status = false;
			String jpql = "select a from Application a where a.aadharNo = :aadharNum";
			Query q = em.createQuery(jpql);
			q.setParameter("aadharNum", aadharNo);
			int i = q.getFirstResult();
			if(i < 1) {
				return true;
			}
			else {
				Application application = (Application) q.getSingleResult();
				status = checkLoanStatus(application.getApplicationId());
			}
			return status;
		}
		finally {
			em.close();
			emf.close();
		}
	}
}
