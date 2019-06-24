package com.sakila.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sakila.entity.Inventory;

@Repository
public interface InventoryRepository extends PagingAndSortingRepository<Inventory, Long>{

}
