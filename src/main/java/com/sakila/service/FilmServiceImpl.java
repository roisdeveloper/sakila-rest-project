package com.sakila.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sakila.entity.Film;
import com.sakila.repository.FilmRepository;

@Service
public class FilmServiceImpl implements FilmService{

	@Autowired
	private FilmRepository repository;
	
	@Override
	public Page<Film> showAllFilm(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Film showFilmByFilmId(Long film_id) {
		Optional<Film> optionalFilm=repository.findById(film_id);		
		if(optionalFilm.isPresent()) {
			return optionalFilm.get();
		}
		return null;
	}
}
