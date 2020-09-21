package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

public class AdminDao extends GenericDao {

	public boolean exists(String username) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			
			String jpql = "select count(a.id) from Admin a where a.username = :username";
			Query q = em.createQuery(jpql);
			q.setParameter("username", username);
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
	
	public long adminLogin(String username, String password) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			
			String jpql = "select a.id from Admin a where a.username =:username and a.password =:password";
			Query q = em.createQuery(jpql);
			q.setParameter("username", username);
			q.setParameter("password", password);
			Integer id = (Integer) q.getSingleResult();
			return id;
			
		}
		finally {
			em.close();
			emf.close();
		}
	}
}

