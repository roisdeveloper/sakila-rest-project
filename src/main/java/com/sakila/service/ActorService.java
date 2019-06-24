package com.sakila.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sakila.entity.Actor;

public interface ActorService {
	public Page<Actor> showAllActor(Pageable pageable);
	public Actor showActorByActorId(Long actor_id);
}
