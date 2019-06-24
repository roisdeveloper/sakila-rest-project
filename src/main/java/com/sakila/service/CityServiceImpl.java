package com.sakila.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sakila.entity.City;
import com.sakila.repository.CityRepository;

@Service
public class CityServiceImpl implements CityService{

	@Autowired
	private CityRepository repository;
	
	
	@Override
	public Page<City> showAllCity(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public City showCityByCityId(Long city_id) {
		Optional<City> optionalCity=repository.findById(city_id);		
		if(optionalCity.isPresent()) {
			return optionalCity.get();
		}
		return null;
	}
	
	

}
