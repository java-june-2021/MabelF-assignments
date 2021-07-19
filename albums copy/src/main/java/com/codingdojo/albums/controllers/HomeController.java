package com.codingdojo.albums.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.albums.models.Album;
import com.codingdojo.albums.services.AlbumService;

@Controller
public class HomeController {
	// Dependency injection
	@Autowired 
	private AlbumService aService;
	
	
	@GetMapping("/")
	public String index(Model viewModel) {
		viewModel.addAttribute("allAlbums", this.aService.allAlbums());
		return "/album/index.jsp";
	}
	
	
	@GetMapping("/new")
	public String newAlbum(@ModelAttribute("album") Album album ) {
		return "/album/new.jsp";
	}
	
	@PostMapping("/addRecord")
	public String addAlbumJSTL(@Valid @ModelAttribute("album") Album album, BindingResult  result) {
		if (result.hasErrors()) {
			return "/album/new.jsp"; //Rerender 
		}
		this.aService.createAlbum(album);
		return "redirect:/";
	}
	
	
	
	
	@PostMapping("/addRecordHTMLWay")
	public String addAlbum(@RequestParam("bandName") String bandName, @RequestParam("albumName") String albumName, @RequestParam("releaseYear") int releaseYear, RedirectAttributes redirectAttr) {
		// Validation Arraylist
		ArrayList<String> errors = new ArrayList<>(); 
		if (bandName.equals("")) {
			errors.add("Needs to be non empty");
		}
		if (errors.size() > 0) {
			for (String e : errors) {
				redirectAttr.addFlashAttribute("error", e);
			}
			return "redirect:/new";
			
		}
		
		
		// Create album
		Album newAlbum = new Album(bandName, albumName, releaseYear); // Hit control shift o
		this.aService.createAlbum(newAlbum); // Somehow saves to repository
		
		return "redirect:/"; // Go back to base URL
	}
}
