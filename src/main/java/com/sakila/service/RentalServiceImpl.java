package com.sakila.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sakila.entity.Rental;
import com.sakila.repository.RentalRepository;

@Service
public class RentalServiceImpl implements RentalService{

	@Autowired
	private RentalRepository repository;
	@Override
	public Page<Rental> showAllRental(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Rental showRentalByRentalId(Long rental_id) {
		Optional<Rental> optionalRental=repository.findById(rental_id);		
		if(optionalRental.isPresent()) {
			return optionalRental.get();
		}
		return null;
	}

}
