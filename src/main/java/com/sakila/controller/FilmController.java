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

import com.sakila.entity.Film;
import com.sakila.exception.EntityNotFoundException;
import com.sakila.service.FilmService;

@RestController
@RequestMapping(value="/api/film/")
public class FilmController {
	private static Logger LOG=LoggerFactory.getLogger(FilmController.class);
	@Autowired
	private FilmService service;
	
	@GetMapping(value="/show",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Film>> showAllFilm(Pageable pageable){
		Page<Film> filmPage=service.showAllFilm(pageable);
		if(filmPage.isEmpty()) {
			LOG.info("NO CONTENT");
			return new ResponseEntity<Page<Film>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<Film>>(filmPage,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(value="/show/{film_id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Film> showByFilmId(@PathVariable(name="film_id") Long film_id){
		Film film=service.showFilmByFilmId(film_id);
		if(film == null) {	
			LOG.info("NO CONTENT");
			throw new EntityNotFoundException("ID "+film_id+" not found.");
		}
		return new ResponseEntity<Film>(film,new HttpHeaders(),HttpStatus.OK);
	}
}
