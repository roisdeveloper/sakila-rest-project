package com.sakila.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sakila.entity.City;;

public interface CityService {
	public Page<City> showAllCity(Pageable pageable);
	public City showCityByCityId(Long city_id);
}
