package com.sakila.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sakila.entity.Rental;

public interface RentalService {
	public Page<Rental> showAllRental(Pageable pageable);
	public Rental showRentalByRentalId(Long rental_id);
}
