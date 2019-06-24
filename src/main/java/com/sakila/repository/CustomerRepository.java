package com.sakila.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sakila.entity.Customer;

@Repository
public interface CustomerRepository extends PagingAndSortingRepository<Customer, Long>{

}
