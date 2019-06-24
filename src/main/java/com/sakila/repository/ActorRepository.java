package com.sakila.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sakila.entity.Actor;

@Repository
public interface ActorRepository extends PagingAndSortingRepository<Actor, Long> {

}
