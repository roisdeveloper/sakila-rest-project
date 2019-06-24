package com.sakila.repository;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import com.sakila.entity.Category;

@Repository
public interface CategoryRepository extends PagingAndSortingRepository<Category, Long>{
	
	@Query(value="INSERT INTO category (name) VALUES (:name)",nativeQuery=true)
	public void insertCategory(@Param("name") String name);
}
