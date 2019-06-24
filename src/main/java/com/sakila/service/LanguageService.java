package com.sakila.service;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import com.sakila.entity.Language;

public interface LanguageService {
	public Page<Language> showAllLanguage(Pageable pageable);
	public Language showLanguageByLanguageId(Long language_id);
}
