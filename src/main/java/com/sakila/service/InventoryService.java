package com.sakila.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sakila.entity.Inventory;

public interface InventoryService {
	public Page<Inventory> showAllInventory(Pageable pageable);
	public Inventory showInventoryByInventoryId(Long inventory_id);
}
