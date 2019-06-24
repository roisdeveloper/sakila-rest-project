package com.sakila.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import com.sakila.entity.Language;
import com.sakila.repository.LanguageRepository;

@Service
public class LanguageServiceImpl implements LanguageService {

	@Autowired
	private LanguageRepository repository;
	
	@Override
	public Page<Language> showAllLanguage(Pageable pageable) {
		return repository.findAll(pageable);
	}

	@Override
	public Language showLanguageByLanguageId(Long language_id) {
		Optional<Language> optionalLanguage=repository.findById(language_id);		
		if(optionalLanguage.isPresent()) {
			return optionalLanguage.get();
		}
		return null;
	}

}
