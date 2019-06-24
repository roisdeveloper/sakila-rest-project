package com.sakila.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sakila.entity.Country;
import com.sakila.repository.CountryRepository;

@Service
public class CountryServiceImpl implements CountryService{

	@Autowired
	private CountryRepository repository;
	@Override
	public Page<Country> showAllCountry(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Country showCountryByCountryId(Long country_id) {
		Optional<Country> optionalCountry=repository.findById(country_id);		
		if(optionalCountry.isPresent()) {
			return optionalCountry.get();
		}
		return null;
	}

}
