package com.sakila.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sakila.entity.Film;

@Repository
public interface FilmRepository extends PagingAndSortingRepository<Film, Long> {

}
