package com.sakila.controller;

import javax.validation.Valid;


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
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.util.UriComponentsBuilder;

import com.sakila.entity.Category;
import com.sakila.exception.EntityNotFoundException;
import com.sakila.service.CategoryServiceImpl;

@RestController
@RequestMapping(value="/api/category/")
public class CategoryController {
	private static Logger LOG=LoggerFactory.getLogger(CategoryController.class);
	@Autowired
	private CategoryServiceImpl service;
	
	@GetMapping(value="/show",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Category>> showAllCategory(Pageable pageable){
		Page<Category> categoriesPage=service.showAllCategory(pageable);
		if(categoriesPage.isEmpty()) {
			LOG.info("NO CONTENT");
			return new ResponseEntity<Page<Category>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<Category>>(categoriesPage,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(value="/show/{category_id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Category> showByCategoryId(@PathVariable(name="category_id") Long category_id){
		Category category=service.showCategoryByCategoryId(category_id);
		if(category == null) {	
			LOG.info("NO CONTENT");
			throw new EntityNotFoundException("ID "+category_id+" not found.");
		}
		return new ResponseEntity<Category>(category,new HttpHeaders(),HttpStatus.OK);
	}
	
	
	@PostMapping(value="/insert")
	public ResponseEntity<Void> insertCategory(@RequestBody @Valid Category category,
			UriComponentsBuilder uComponentsBuilder) {
		try {
			service.insertCategory(category.getName());
			HttpHeaders headers=new HttpHeaders();
			headers.setLocation(uComponentsBuilder.path("/show/{category_id}")
					.buildAndExpand(
							category.getCategoryId()).toUri()
					);
			LOG.info("Insert new data : Category. Successfully!");
			return new ResponseEntity<Void>(headers,HttpStatus.CREATED);
		}catch(Exception e) {
			LOG.info("FAILED INSERT DATA");
			return new ResponseEntity<Void>(HttpStatus.INTERNAL_SERVER_ERROR);
		}		
	}
}
