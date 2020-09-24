package com.lti.dao;

import java.util.List;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Application;
import com.lti.entity.Property;

public class AdminApplicationPropertyDao {
	public List<Application> getApplicants() {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();      
			String jpql = "select a from Application a";
			Query q = em.createQuery(jpql,Application.class);
			List<Application> list = q.getResultList();
			return list;
		}
		finally {
			em.close();
			emf.close();
		}
		
	}
	
	public List<Property> getProperty() {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();      
			String jpql = "select p from Property p";
			Query q = em.createQuery(jpql);
			List<Property> list = q.getResultList();
			return list;
		}
		finally {
			em.close();
			emf.close();
		}
		
	}
	
	public Application applicationDetailByApplicationId(int appId) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			
			String jpql = "select a from Application a where a.applicationId =:appId";
			Query q = em.createQuery(jpql);
			q.setParameter("appId", appId);
			Application applicant = (Application) q.getSingleResult();
			return applicant;
		}
		finally {
			em.close();
			emf.close();
		}
	}
	
	public Property propertyDetailByApplicationId(int appId) {
		EntityManagerFactory emf = null;
		EntityManager em = null;
		
		try {
			emf = Persistence.createEntityManagerFactory("ourHomeLoan");
			em = emf.createEntityManager();
			
			String jpql = "select p from Property p where p.application.applicationId =:appId";
			Query q = em.createQuery(jpql);
			q.setParameter("appId", appId);
			Property property = (Property) q.getSingleResult();
			return property;
		}
		finally {
			em.close();
			emf.close();
		}
	}
}
