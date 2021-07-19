package com.codingdojo.languages.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;


// Remember to import both the model and the service. 
@RestController
@RequestMapping("/api")
public class APIController {
	// Dependency injection
	@Autowired 
	private LanguageService lService;
	
	
	@GetMapping("") // If you use /api you need to not have a / here.
	public List<Language> allLanguages() {
		return this.lService.allLanguages();
	}

	@GetMapping("/id")
	public Language findLanguageById(@PathVariable("id") Long id) {
		return this.lService.findLanguageById(id);
	}
	
	@PostMapping("create")
	public Language createLanguage(Language language) {
		return this.lService.createLanguage(language);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteLanguage(@PathVariable("id") Long id) {
		this.lService.deleteLanguage(id);
	}
	
	@PutMapping("/{id}")
	public void updateLanguage(@PathVariable("id") Long id, Language language) {
		this.lService.updateLanguage(id, language);
	}

}
