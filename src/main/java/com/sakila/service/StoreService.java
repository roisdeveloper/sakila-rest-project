package com.sakila.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sakila.entity.Store;

public interface StoreService {
	public Page<Store> showAllStore(Pageable pageable);
	public Store showStoreByStoreId(Long Store_id);
}
