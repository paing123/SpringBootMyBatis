package com.paing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paing.dao.AdminDao;
import com.paing.model.Admin;

@Service("adminService")
public class AdminServiceImpl implements AdminService {

	@Autowired
	AdminDao adminDao;

	@Override
	public void save(Admin admin) {
		adminDao.save(admin);
	}

	@Override
	public List<Admin> findAdmin(Admin admin) {
		return adminDao.findAdmin(admin);
	}
	
	@Override
	public void delete(Integer id) {
		adminDao.delete(id);
	}

	public void update(Admin admin) {
		adminDao.update(admin);
	}
}