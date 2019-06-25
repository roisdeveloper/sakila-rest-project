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

import com.sakila.entity.Country;
import com.sakila.exception.EntityNotFoundException;
import com.sakila.service.CountryService;

@RestController
@RequestMapping(value="/api/country/")
public class CountryController {
	private static Logger LOG=LoggerFactory.getLogger(CountryController.class);
	@Autowired
	private CountryService service;
	
	
	@GetMapping(value="/show",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Country>> showAllCountry(Pageable pageable){
		Page<Country> countryPages=service.showAllCountry(pageable);
		if(countryPages.isEmpty()) {
			LOG.info("NO CONTENT");
			return new ResponseEntity<Page<Country>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<Country>>(countryPages,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(value="/show/{country_id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Country> showByCountryId(@PathVariable(name="country_id") Long country_id){
		Country country=service.showCountryByCountryId(country_id);
		if(country == null) {	
			LOG.info("NO CONTENT");
			throw new EntityNotFoundException("ID "+country_id+" not found.");
		}
		return new ResponseEntity<Country>(country,new HttpHeaders(),HttpStatus.OK);
	}
	

}
