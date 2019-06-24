package com.sakila.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sakila.entity.Store;

@Repository
public interface StoreRepository extends PagingAndSortingRepository<Store, Long>{

}
