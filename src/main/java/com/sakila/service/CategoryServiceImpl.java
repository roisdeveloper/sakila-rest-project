package com.sakila.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sakila.entity.Category;
import com.sakila.repository.CategoryRepository;

@Service
public class CategoryServiceImpl implements CategoryService{
	
	@Autowired
	private CategoryRepository repository;
	
	@Override
	public Page<Category> showAllCategory(Pageable pageable) {	
		return repository.findAll(pageable);
	}

	@Override
	public Category showCategoryByCategoryId(Long category_id) {
		Optional<Category> optionalCategory=repository.findById(category_id);		
		if(optionalCategory.isPresent()) {
			return optionalCategory.get();
		}
		return null;
	}
	
	@Override
	public void insertCategory(String name) {
		repository.insertCategory(name);
	}
}
