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

import com.sakila.entity.Actor;
import com.sakila.service.ActorService;

@RestController
@RequestMapping(value="/api/actor/")
public class ActorController {
	private static Logger LOG=LoggerFactory.getLogger(ActorController.class);
	@Autowired
	private ActorService service;
	
	@GetMapping(value="/show",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Page<Actor>> showAllActor(Pageable pageable){
		Page<Actor> categoriesPage=service.showAllActor(pageable);
		if(categoriesPage.isEmpty()) {
			LOG.info("NO CONTENT");
			return new ResponseEntity<Page<Actor>>(HttpStatus.NO_CONTENT);
		}
		return new ResponseEntity<Page<Actor>>(categoriesPage,new HttpHeaders(),HttpStatus.OK);
	}
	
	@GetMapping(value="/show/{actor_id}",produces=MediaType.APPLICATION_JSON_VALUE)
	public ResponseEntity<Actor> showByActorId(@PathVariable(name="actor_id") Long actor_id){
		Actor actor=service.showActorByActorId(actor_id);
		if(actor == null) {	
			LOG.info("NO CONTENT");
			return new ResponseEntity<Actor>(HttpStatus.NOT_FOUND);
		}
		return new ResponseEntity<Actor>(actor,new HttpHeaders(),HttpStatus.OK);
	}
}
