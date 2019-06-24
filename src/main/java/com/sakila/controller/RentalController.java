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

import com.sakila.entity.Rental;
import com.sakila.service.RentalService;

@RestController
@RequestMapping(value="/api/rental/")
public class RentalController {
	private static Logger LOG=LoggerFactory.getLogger(RentalController.class);
	@Autowired
	private RentalService service;
	
	@GetMapping(value="/show",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Rental>> showAllRental(Pageable pageable){
		Page<Rental> categoriesPage=service.showAllRental(pageable);
		if(categoriesPage.isEmpty()) {
			LOG.info("NO CONTENT");
			return new ResponseEntity<Page<Rental>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<Rental>>(categoriesPage,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(value="/show/{rental_id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Rental> showByRentalId(@PathVariable(name="rental_id") Long rental_id){
		Rental rental=service.showRentalByRentalId(rental_id);
		if(rental == null) {	
			LOG.info("NO CONTENT");
			return new ResponseEntity<Rental>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Rental>(rental,new HttpHeaders(),HttpStatus.OK);
	}
}
