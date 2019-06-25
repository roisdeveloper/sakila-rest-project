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

import com.sakila.entity.Inventory;
import com.sakila.exception.EntityNotFoundException;
import com.sakila.service.InventoryService;

@RestController
@RequestMapping(value="/api/inventory/")
public class InventoryController {

	private static Logger LOG=LoggerFactory.getLogger(InventoryController.class);
	@Autowired
	private InventoryService service;
	
	@GetMapping(value="/show",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Inventory>> showAllInventory(Pageable pageable){
		Page<Inventory> inventoryPage=service.showAllInventory(pageable);
		if(inventoryPage.isEmpty()) {
			LOG.info("NO CONTENT");
			return new ResponseEntity<Page<Inventory>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<Inventory>>(inventoryPage,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(value="/show/{Inventory_id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Inventory> showByInventoryId(@PathVariable(name="inventory_id") Long inventory_id){
		Inventory inventory=service.showInventoryByInventoryId(inventory_id);
		if(inventory == null) {	
			LOG.info("NO CONTENT");
			throw new EntityNotFoundException("ID "+inventory_id+" not found.");
		}
		return new ResponseEntity<Inventory>(inventory,new HttpHeaders(),HttpStatus.OK);
	}
	
}
