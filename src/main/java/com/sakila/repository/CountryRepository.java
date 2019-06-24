package com.sakila.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sakila.entity.Country;

@Repository
public interface CountryRepository extends PagingAndSortingRepository<Country, Long>{

}
