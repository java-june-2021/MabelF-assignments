package com.codingdojo.languages.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.codingdojo.languages.models.Language;

@Repository
public interface LanguageRepository extends CrudRepository<Language, Long> {
	// Make sure all imports add up
	List<Language> findAll(); // SELECT * FROM ALBUMS - where is this implemented?
}
