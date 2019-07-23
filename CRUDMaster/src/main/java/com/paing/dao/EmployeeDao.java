package com.paing.dao;

import java.util.List;

import com.paing.model.Employee;

public interface EmployeeDao {

	void save(Employee employee);
	
	 List<Employee> findEmployee(Employee employee);
	 
	 void delete(Integer id);
	 
	 void update(Employee employee);
}
