package com.paing.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.paing.model.Customer;
import com.paing.model.Employee;

@Mapper
public interface EmployeeMapper {
	public void save(@Param("employee") Employee employee);
	
	public List<Employee> findEmployee(@Param("employee") Employee employee);
	
	public void update(@Param("employee") Employee employee);
	
	public void delete(@Param("id") Integer id);
}
