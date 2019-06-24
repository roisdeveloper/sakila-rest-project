package com.sakila.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sakila.entity.Category;

public interface CategoryService {
	public Page<Category> showAllCategory(Pageable pageable);
	public Category showCategoryByCategoryId(Long category_id);
	public void insertCategory(String name);
}
