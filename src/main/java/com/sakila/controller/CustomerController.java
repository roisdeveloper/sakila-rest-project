package com.sakila.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakila.entity.Customer;
import com.sakila.service.CustomerService;

@RestController
@RequestMapping(value="/api/customer/")
public class CustomerController {

	private static Logger LOG=LoggerFactory.getLogger(CustomerController.class);
	@Autowired
	private CustomerService service;
	
	@GetMapping(value="/show",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Customer>> showAllCustomer(Pageable pageable){
		Page<Customer> categoriesPage=service.showAllCustomer(pageable);
		if(categoriesPage.isEmpty()) {
			LOG.info("NO CONTENT");
			return new ResponseEntity<Page<Customer>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<Customer>>(categoriesPage,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(value="/show/{customer_id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Customer> showByCustomerId(@PathVariable(name="customer_id") Long customer_id){
		Customer customer=service.showCustomerByCustomerId(customer_id);
		if(customer == null) {	
			LOG.info("NO CONTENT");
			return new ResponseEntity<Customer>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Customer>(customer,new HttpHeaders(),HttpStatus.OK);
	}
}
