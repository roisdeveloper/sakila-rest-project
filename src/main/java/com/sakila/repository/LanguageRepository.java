package com.sakila.repository;

import org.springframework.data.repository.PagingAndSortingRepository;
import org.springframework.stereotype.Repository;

import com.sakila.entity.Language;

@Repository
public interface LanguageRepository extends PagingAndSortingRepository<Language, Long>{

}
