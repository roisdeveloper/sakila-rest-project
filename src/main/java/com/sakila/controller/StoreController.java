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

import com.sakila.entity.Store;
import com.sakila.exception.EntityNotFoundException;
import com.sakila.service.StoreService;

@RestController
@RequestMapping(value="/api/store/")
public class StoreController {
	private static Logger LOG=LoggerFactory.getLogger(StoreController.class);
	@Autowired
	private StoreService service;
	
	@GetMapping(value="/show",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Store>> showAllStore(Pageable pageable){
		Page<Store> storePage=service.showAllStore(pageable);
		if(storePage.isEmpty()) {
			LOG.info("NO CONTENT");
			return new ResponseEntity<Page<Store>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<Store>>(storePage,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(value="/show/{store_id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Store> showByStoreId(@PathVariable(name="store_id") Long store_id){
		Store store=service.showStoreByStoreId(store_id);
		if(store == null) {	
			LOG.info("NO CONTENT");
			throw new EntityNotFoundException("ID "+store_id+" not found.");
		}
		return new ResponseEntity<Store>(store,new HttpHeaders(),HttpStatus.OK);
	}
}
