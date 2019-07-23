package com.paing.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.paing.dao.CustomerDao;
import com.paing.model.Customer;

@Service("customerService")
public class CustomerServiceImpl implements CustomerService {

	@Autowired
	CustomerDao customerdao;

	@Override
	public void save(Customer customer) {
		customerdao.save(customer);
	}

	@Override
	public List<Customer> findCustomer(Customer customer) {
		return customerdao.findCustomer(customer);
	}
	
	@Override
	public void delete(Integer id) {
		customerdao.delete(id);
	}

	public void update(Customer customer) {
		customerdao.update(customer);
	}
}