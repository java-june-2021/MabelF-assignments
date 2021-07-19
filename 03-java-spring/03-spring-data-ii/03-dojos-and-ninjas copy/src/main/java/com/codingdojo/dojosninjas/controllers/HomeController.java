package com.codingdojo.dojosninjas.controllers;

import java.util.ArrayList;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.dojosninjas.models.Album;
import com.codingdojo.dojosninjas.models.Label;
import com.codingdojo.dojosninjas.services.AlbumService;
import com.codingdojo.dojosninjas.services.LabelService;

@Controller
public class HomeController {
	// Dependency injection
	@Autowired 
	private AlbumService aService;
	@Autowired 
	private LabelService lService;
	
	
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
	
	
	@GetMapping("/album/{id}")
	public String show(Model viewModel, @PathVariable("id") Long id, @ModelAttribute("label") Label label) {
		Album albumToShow = this.aService.getOneAlbum(id);
		viewModel.addAttribute("album", albumToShow);
		return "/album/show.jsp";
	}
	
	
	@PostMapping("/{albumId}/addlabel")
	public String addlabel(@Valid @ModelAttribute("label") Label label, BindingResult result, Model viewModel, @PathVariable("albumId") Long id) {
		if (result.hasErrors()) {
			Album albumToShow = this.aService.getOneAlbum(id);
			viewModel.addAttribute("album", albumToShow);
			return "/album/show.jsp"; // Need to duplicate this code from above
		}
		// We need to make the album object
		// We are not using hidden fields
		Album albumForLabel = this.aService.getOneAlbum(id);
		label.setAlbum(albumForLabel);
		this.lService.createLabel(label);
		return "redirect:/album/{albumId}";
	}
	
	// For editing an album ----------
	@GetMapping("/{id}/edit")
	public String edit(@ModelAttribute("album") Album album, Model viewModel, @PathVariable("id") Long id) {
		// The album object already exists. 
		viewModel.addAttribute("album", this.aService.getOneAlbum(id)); // This name has to match
		return "/album/edit.jsp";
	}
	
	@PostMapping("/{id}/edit") // Spring MVC Forms needs the paths to be the same, putmapping as in the platform, won't show the validations so we're using post here
	public String processEdit(@Valid @ModelAttribute("album") Album album, BindingResult result, Model viewModel,  @PathVariable("id") Long id) {
		if (result.hasErrors()) {
			viewModel.addAttribute("album", this.aService.getOneAlbum(id)); // This name has to match
			return "/album/edit.jsp";
		}
		this.aService.updateAlbum(album);
		return "redirect:/album/{id}";
	}
	
	// For deleting an album ----------
	@GetMapping("/{id}/delete")
	public String delete(@PathVariable("id") Long id) {
		this.aService.deleteAlbum(id);
		return "redirect:/";
	}
	
}
