package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;

import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Application;


	public class ApplicationDao extends GenericDao {
		
		
		
		//Checking is applicationWith the appNo Exist or not
		public boolean isApplicationExists(int appNo) {
			EntityManagerFactory emf = null;
			EntityManager em = null;
			
			try {
				emf = Persistence.createEntityManagerFactory("ourHomeLoan");
				em = emf.createEntityManager();
				
				String jpql = "select count(a.id) from Application a where a.applicationId =:appNo";
				Query q = em.createQuery(jpql);
				q.setParameter("appNo", appNo);
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
		
		//CustomerLogin it returns All the customer Details
	
	
}
