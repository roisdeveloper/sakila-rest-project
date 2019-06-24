package com.sakila.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sakila.entity.Rental;

@Repository
public interface RentalRepository extends PagingAndSortingRepository<Rental, Long>{

}
