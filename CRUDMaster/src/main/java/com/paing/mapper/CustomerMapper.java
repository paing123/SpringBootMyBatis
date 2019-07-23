package com.paing.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;
import org.apache.ibatis.annotations.Param;

import com.paing.model.Customer;

@Mapper
public interface CustomerMapper {
	public void save(@Param("customer") Customer customer);
	
	public List<Customer> findCustomer(@Param("customer") Customer customer);
	
	public void update(@Param("customer") Customer customer);
	
	public void delete(@Param("id") Integer id);
}
