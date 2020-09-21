package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class GenericDao {

	public <T> T save(Object obj) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {	
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			EntityTransaction tx = em.getTransaction();
			tx.begin();
			
			T updatedObj = (T) em.merge(obj);
			tx.commit();
			return updatedObj;
		}
		finally {
			em.close();
			emf.close();
		}
		
	}
	
	public <T> T fetchById(Class<T> classname, Object id) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			
			T obj = em.find(classname, id);
			return obj;
		}
		finally {
			em.close();
			emf.close();
		}	
		
	}
	
}

