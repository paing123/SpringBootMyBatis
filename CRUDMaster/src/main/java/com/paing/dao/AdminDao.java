package com.paing.dao;

import java.util.List;

import com.paing.model.Admin;

public interface AdminDao {

	void save(Admin admin);
	
	 List<Admin> findAdmin(Admin admin);
	 
	 void delete(Integer id);
	 
	 void update(Admin admin);
}
