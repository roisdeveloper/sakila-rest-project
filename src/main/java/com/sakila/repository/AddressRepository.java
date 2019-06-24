package com.sakila.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sakila.entity.Address;

@Repository
public interface AddressRepository extends PagingAndSortingRepository<Address, Long>{
	

}
