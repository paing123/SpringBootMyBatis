package com.paing.service;

import java.util.List;

import com.paing.model.Admin;

public interface AdminService {

	void save(Admin admin);

	List<Admin> findAdmin(Admin admin);

	void delete(Integer id);

	void update(Admin admin);
}
