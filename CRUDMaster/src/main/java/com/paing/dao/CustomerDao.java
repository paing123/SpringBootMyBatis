package com.paing.dao;

import java.util.List;

import com.paing.model.Customer;

public interface CustomerDao {

	void save(Customer customer);
	
	 List<Customer> findCustomer(Customer customer);
	 
	 void delete(Integer id);
	 
	 void update(Customer customer);
}
