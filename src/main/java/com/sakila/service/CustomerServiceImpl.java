package com.sakila.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sakila.entity.Customer;
import com.sakila.repository.CustomerRepository;

@Service
public class CustomerServiceImpl implements CustomerService{

	@Autowired
	private CustomerRepository repository;
	
	@Override
	public Page<Customer> showAllCustomer(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Customer showCustomerByCustomerId(Long customer_id) {
		Optional<Customer> optionalCustomer=repository.findById(customer_id);		
		if(optionalCustomer.isPresent()) {
			return optionalCustomer.get();
		}
		return null;
	}

}
