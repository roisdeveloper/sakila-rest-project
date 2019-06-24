package com.sakila.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sakila.entity.Actor;
import com.sakila.repository.ActorRepository;

@Service
public class ActorServiceImpl implements ActorService{

	@Autowired
	private ActorRepository repository;
	
	@Override
	public Page<Actor> showAllActor(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Actor showActorByActorId(Long actor_id) {
		Optional<Actor> optionalActor=repository.findById(actor_id);		
		if(optionalActor.isPresent()) {
			return optionalActor.get();
		}
		return null;
	}

}
