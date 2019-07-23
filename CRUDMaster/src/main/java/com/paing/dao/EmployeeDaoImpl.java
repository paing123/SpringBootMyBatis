package com.paing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.paing.mapper.EmployeeMapper;
import com.paing.model.Employee;

@Repository("employeeDao")
public class EmployeeDaoImpl implements EmployeeDao {
	
	@Autowired
	private EmployeeMapper employeeMapper;
	
	public void save(Employee employee) {
		employeeMapper.save(employee);
	}
	
	public List<Employee> findEmployee(Employee employee) {
		List<Employee> emp = employeeMapper.findEmployee(employee);
		return emp;
	}
	
	public void delete(Integer id) {
		employeeMapper.delete(id);
	}
	
	public void update(Employee employee) {
		employeeMapper.update(employee);
	}

}