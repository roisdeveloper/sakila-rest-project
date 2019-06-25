package com.sakila.controller;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.sakila.entity.City;
import com.sakila.exception.EntityNotFoundException;
import com.sakila.service.CityService;

@RestController
@RequestMapping(value="/api/city/")
public class CityController {
	private static Logger LOG=LoggerFactory.getLogger(CityController.class);
	@Autowired
	private CityService service;

	@GetMapping(value="/show",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<City>> showAllCity(Pageable pageable){
		Page<City> citiesPage=service.showAllCity(pageable);
		if(citiesPage.isEmpty()) {
			LOG.info("NO CONTENT");
			return ResponseEntity.notFound().build();
		}
		
		return new ResponseEntity<Page<City>>(citiesPage,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(value="/show/{city_id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<City> showByCityId(@PathVariable(name="city_id") Long city_id){
		City city=service.showCityByCityId(city_id);
		if(city == null) {	
			LOG.info("NO CONTENT");
			throw new EntityNotFoundException("ID "+city_id+" not found.");
		}
		return new ResponseEntity<City>(city,new HttpHeaders(),HttpStatus.OK);
	}
}
