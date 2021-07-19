package com.codingdojo.languages.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.codingdojo.languages.models.Language;
import com.codingdojo.languages.services.LanguageService;


// Remember to import the service
// This is a typical controller like we had before.
// http://localhost:8080/languages/
@Controller
public class HomeController {
	// Dependency injection
	@Autowired 
	private LanguageService lService;
	
	
	
	// The display of the database and the form under it will be shown on this page.
	@RequestMapping("/languages")
	public String index(@ModelAttribute("language") Language language , Model viewModel) { // Landing page: http://localhost:8080/languages
		viewModel.addAttribute("allLanguages", this.lService.allLanguages());
		return "/languages/index.jsp";
	}
	
	
	// For adding something - this is not an endpoint. This is connected to the form
	@PostMapping("/languages")
	public String addAlbumJSTL(@Valid @ModelAttribute("language") Language language, BindingResult result, Model viewModel) {
		viewModel.addAttribute("allLanguages", this.lService.allLanguages()); // Add this so it's visible even if it errors
		if (result.hasErrors()) {
			return "/languages/index.jsp"; //Rerender  
		}
		this.lService.createLanguage(language);
//		return "redirect:/";
		return "redirect:/languages";
	}
	
	
	
	// For the edit page ---------------------------------------------------------
	@RequestMapping("/languages/edit/{editId}")
	public String edit(@PathVariable("editId") String editId, Model viewModel){
		Long editId2 = Long.parseLong(editId);
		Language language = lService.findLanguageById(editId2);
        if (language != null){
            viewModel.addAttribute("language", language);
            return "/languages/editLanguage.jsp";
        }else{
            return "redirect:/languages";
        }
	}
	
	// For the edit form -------------------------------------------------------------------
	@PostMapping("/languages/edit/{editId}")
    public String updateLanguage(@PathVariable("editId") Long editId, @Valid @ModelAttribute("language") Language language, BindingResult result) {
        if (result.hasErrors()) {
        		return "/languages/editLanguage.jsp";
        }else{
            lService.updateLanguage(editId, language); // See service. I modified it to take 2 args.
            return "redirect:/languages";
        }
    }
	
	
	// Delete Functionality -----------
	@RequestMapping("/languages/delete/{id}")
	public String deleteLanguage(@PathVariable("id") Long id) {
		this.lService.deleteLanguage(id);
		return "redirect:/languages";
	}
	
	
	// For the details page -------------------------------------------------------------------
	@DeleteMapping("/languages/{id}")
	public String details(@PathVariable("id") String id, Model viewModel){
		Long editId2 = Long.parseLong(id);
		Language language = lService.findLanguageById(editId2);
        if (language != null){
            viewModel.addAttribute("language", language);
            return "/languages/detail.jsp";
        } else {
            return "redirect:/languages";
        }
	}
	
}
