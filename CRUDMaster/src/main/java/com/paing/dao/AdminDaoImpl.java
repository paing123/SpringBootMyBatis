package com.paing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.paing.mapper.AdminMapper;
import com.paing.model.Admin;

@Repository("adminDao")
public class AdminDaoImpl implements AdminDao {
	
	@Autowired
	private AdminMapper adminMapper;
	
	public void save(Admin admin) {
		adminMapper.save(admin);
	}
	
	public List<Admin> findAdmin(Admin admin) {
		List<Admin> admins = adminMapper.findAdmin(admin);
		return admins;
	}
	
	public void delete(Integer id) {
		adminMapper.delete(id);
	}
	
	public void update(Admin admin) {
		adminMapper.update(admin);
	}

}