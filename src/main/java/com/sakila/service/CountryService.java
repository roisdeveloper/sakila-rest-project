package com.sakila.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sakila.entity.Country;

public interface CountryService {
	public Page<Country> showAllCountry(Pageable pageable);
	public Country showCountryByCountryId(Long country_id);
}
