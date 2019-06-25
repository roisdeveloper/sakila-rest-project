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
import com.sakila.entity.Address;
import com.sakila.exception.EntityNotFoundException;
import com.sakila.service.AddressService;


@RestController
@RequestMapping(value="/api/address/")
public class AddressController {

	private static Logger LOG=LoggerFactory.getLogger(AddressController.class);
	@Autowired
	private AddressService service;
	

	@GetMapping(value="/show",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Address>> showAllAddress(Pageable pageable){
		Page<Address> addressPage=service.showAllAddress(pageable);
		if(addressPage.isEmpty()) {
			LOG.info("NO CONTENT");
			return new ResponseEntity<Page<Address>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<Address>>(addressPage,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(value="/show/{address_id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Address> showByAddressId(@PathVariable(name="address_id") Long address_id){
		Address address=service.showAddressByAddressId(address_id);
		if(address == null) {	
			LOG.info("NO CONTENT");
			throw new EntityNotFoundException("ID "+address_id+" not found.");
		}
		return new ResponseEntity<Address>(address,new HttpHeaders(),HttpStatus.OK);
	}
}
