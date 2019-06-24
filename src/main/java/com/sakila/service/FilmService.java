package com.sakila.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import com.sakila.entity.Film;

public interface FilmService {
	public Page<Film> showAllFilm(Pageable pageable);
	public Film showFilmByFilmId(Long film_id);
}
