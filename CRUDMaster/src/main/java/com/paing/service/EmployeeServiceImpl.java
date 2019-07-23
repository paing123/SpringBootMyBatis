package com.paing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paing.dao.EmployeeDao;
import com.paing.model.Employee;

@Service("employeeService")
public class EmployeeServiceImpl implements EmployeeService {

	@Autowired
	EmployeeDao employeedao;

	@Override
	public void save(Employee employee) {
		employeedao.save(employee);
	}

	@Override
	public List<Employee> findEmployee(Employee employee) {
		return employeedao.findEmployee(employee);
	}
	
	@Override
	public void delete(Integer id) {
		employeedao.delete(id);
	}

	public void update(Employee employee) {
		employeedao.update(employee);
	}
}