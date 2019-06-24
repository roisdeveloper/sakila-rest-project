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

import com.sakila.entity.Language;
import com.sakila.service.LanguageService;

@RestController
@RequestMapping(value="/api/language/")
public class LanguageController {
	private static Logger LOG=LoggerFactory.getLogger(LanguageController.class);
	
	@Autowired
	private LanguageService service;
	
	@GetMapping(value="/show",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Language>> showAllLanguage(Pageable pageable){
		Page<Language> categoriesPage=service.showAllLanguage(pageable);
		if(categoriesPage.isEmpty()) {
			LOG.info("NO CONTENT");
			return new ResponseEntity<Page<Language>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<Language>>(categoriesPage,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(value="/show/{language_id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Language> showByLanguageId(@PathVariable(name="language_id") Long language_id){
		Language language=service.showLanguageByLanguageId(language_id);
		if(language == null) {	
			LOG.info("NO CONTENT");
			return new ResponseEntity<Language>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Language>(language,new HttpHeaders(),HttpStatus.OK);
	}

}
