package com.sakila.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sakila.entity.City;

@Repository
public interface CityRepository extends PagingAndSortingRepository<City, Long>{
	

}
