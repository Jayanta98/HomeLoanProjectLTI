package com.lti.dao;

import java.util.ArrayList;
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
	
	public int checkLoanStatus(int appNo) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			
			String jpql = "select l from Loan l where l.application.applicationId = :appId";
			Query q = em.createQuery(jpql);
			q.setParameter("appId", appNo);
			Loan loan = (Loan) q.getSingleResult();
			
			System.out.println(loan.getLoanStatus());
			System.out.println(loan.getLoanId());
			if(loan.getLoanStatus().equals("Completed") || loan.getLoanStatus().equals("Rejected")) {
				return 1;
			}
			else {
				return 0;
			}
				
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
			String jpql = "select count(a.applicationId) from Application a where a.aadharNo = :aadharNo";
			Query q = em.createQuery(jpql);
			q.setParameter("aadharNo", aadharNo);
			Long i = (Long) q.getSingleResult();
			
			System.out.println(i);
			if(i < 1) {
				System.out.println("kk1");
				return true;
				
			}
			else {
				emf = Persistence.createEntityManagerFactory("ourHomeLoan");
				em = emf.createEntityManager();
				System.out.println("mmmm");
				String jpql2 = "select  a from Application a where a.aadharNo =:aadharNo";
				Query q2 = em.createQuery(jpql2);
				q2.setParameter("aadharNo", aadharNo);
				List<Application> applicationList = (List<Application>)q2.getResultList();
				ArrayList<Integer> ans=new ArrayList<Integer>();
				for(Application application:applicationList)
				{
					int x = checkLoanStatus(application.getApplicationId());
					ans.add(x);
				}
				if(ans.contains(0))
				{
					return false;
				}
				else
				{
					return true;
				}
					
				
			}
			//return status;
		}
		finally {
			em.close();
			emf.close();
		}
	}
}
