package com.lti.service;

import com.lti.dao.AdminDao;
import com.lti.dao.GenericDao;
import com.lti.entity.Admin;
import com.lti.exception.AdminServiceException;

public class AdminService {

	public int registerAdmin(Admin admin) {
		GenericDao dao = new GenericDao();
		admin = dao.save(admin);
		return admin.getId();
	}
	
	public Admin adminLogin(String username, String password) {
		AdminDao ad = new AdminDao();
		GenericDao dao = new GenericDao();
		if(ad.exists(username)) {
			try {
				int id = (int) ad.adminLogin(username, password);
				Admin admin = dao.fetchById(Admin.class, id);
				return admin;
			} catch (Exception e) {
				throw new AdminServiceException("Incorrect username/password");
			}
		}
		else {
			throw new AdminServiceException("Admin not present in Database");
		}
	}
	
	
}

