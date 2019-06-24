package com.sakila.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sakila.entity.Inventory;
import com.sakila.repository.InventoryRepository;

@Service
public class InventoryServiceImpl implements InventoryService{

	@Autowired
	private InventoryRepository repository;
	@Override
	public Page<Inventory> showAllInventory(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Inventory showInventoryByInventoryId(Long inventory_id) {
		Optional<Inventory> optionalInventory=repository.findById(inventory_id);		
		if(optionalInventory.isPresent()) {
			return optionalInventory.get();
		}
		return null;
	}

}
