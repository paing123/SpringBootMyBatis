package com.paing.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.paing.mapper.CustomerMapper;
import com.paing.model.Customer;

@Repository("customerDao")
public class CustomerDaoImpl implements CustomerDao {
	
	@Autowired
	private CustomerMapper customerMapper;
	
	public void save(Customer customer) {
		customerMapper.save(customer);
	}
	
	public List<Customer> findCustomer(Customer customer) {
		List<Customer> customers = customerMapper.findCustomer(customer);
		return customers;
	}
	
	public void delete(Integer id) {
		customerMapper.delete(id);
	}
	
	public void update(Customer customer) {
		customerMapper.update(customer);
	}

}