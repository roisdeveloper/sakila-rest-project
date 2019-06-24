package com.sakila.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sakila.entity.Customer;

public interface CustomerService {
	public Page<Customer> showAllCustomer(Pageable pageable);
	public Customer showCustomerByCustomerId(Long customer_id);
}
