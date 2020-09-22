package com.lti.dao;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;
import javax.persistence.Query;

import com.lti.entity.Admin;
import com.lti.exception.AdminServiceException;

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
	
	
	public int registerAdmin(Admin admin) {
		GenericDao dao = new GenericDao();
		admin = dao.save(admin);
		return admin.getId();
	}
	
	
	public int getAdminId(String username, String password) {
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
	
	
	public Admin adminLogin(String username, String password) {
		GenericDao dao = new GenericDao();
		boolean adminExists = exists(username);
		
		if(adminExists) {
			try {
				int id = getAdminId(username, password);
				Admin admin = dao.fetchById(Admin.class, id);
				return admin;
			}
			catch(Exception e) {
				throw new AdminServiceException("Incorrect username/password");
			}
		}
		else {
			throw new AdminServiceException("Admin not present in Database");
		}
	}
}

