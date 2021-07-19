package com.codingdojo.languages.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.repositories.LanguageRepository;

@Service
public class LanguageService { 
	// Dependency injection.
	// Will rely on the repository which relies on the methods it defines and also those it inherits from "CrudRepository"
	private LanguageRepository lRepo;
	
	public LanguageService(LanguageRepository lRepo) {
		this.lRepo = lRepo;
	}
	
	// Display all languages
	public List<Language> allLanguages() {
		return this.lRepo.findAll();
	}
	
	// Create
	public Language createLanguage(Language language) {
		return this.lRepo.save(language);
	}
	
	// Read
	public Language findLanguageById(Long id) { // Renamed
		return this.lRepo.findById(id).orElse(null);
	}
	
	// Update
	public Language updateLanguage(Long id, Language language) {
		System.out.println("in here");
		Language languageExisting = this.lRepo.findById(id).get(); 
		languageExisting.setCurrentVersion(language.getCurrentVersion());
		languageExisting.setName(language.getName());
		languageExisting.setCreator(language.getCreator());
		return this.lRepo.save(languageExisting);
	}
	
	
	// Delete (seems to return a string, what are the actual return types for it?)
	public String deleteLanguage(Long id) {
		this.lRepo.deleteById(id);
		return "Language with id: " + id + " has been deleted.";
 	}
	
}
