package com.codingdojo.albums.controllers;

import java.util.ArrayList;

import javax.servlet.http.HttpSession;
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

import com.codingdojo.albums.models.Album;
import com.codingdojo.albums.models.Label;
import com.codingdojo.albums.models.User;
import com.codingdojo.albums.services.AlbumService;
import com.codingdojo.albums.services.LabelService;
import com.codingdojo.albums.services.UserService;
import com.codingdojo.albums.validators.UserValidator;

@Controller
public class HomeController {
	// Dependency injection
	@Autowired 
	private AlbumService aService;
	@Autowired 
	private LabelService lService;
	@Autowired
	private UserService uService;
	@Autowired
	private UserValidator validator;
	
	
	// HOMEPAGE -------------------------------------------------------------------------------------
	@GetMapping("/")
	public String index(@ModelAttribute("user") User user) { // You should change this for lecture tomorrow
//		viewModel.addAttribute("users", this.uService.allUsers()); // Grabs everything and affix to model
		return "index.jsp";
	}
	
	
	// REGISTRATION -------------------------------------------------------------------------------
	@PostMapping("/register")
	public String register(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
		validator.validate(user, result); // Errors will be printed to jsp by binding result
		if (result.hasErrors()) {
			return "index.jsp";
		}
		User newUser = this.uService.registerUser(user);
		session.setAttribute("user__id", newUser.getId());
		return "redirect:/albums";
	}
	
	
	// LOGIN WITH NORMAL HTML FORMS
	@PostMapping("/login") 
	public String login(@RequestParam("lemail") String email, @RequestParam("lpassword") String password, RedirectAttributes redirectAttr, HttpSession session) {
		if (!this.uService.authenticateUser(email, password)) {
			redirectAttr.addFlashAttribute("loginError", "Wrong credentials");
			return "redirect:/";
		}
		User user = this.uService.getByEmail(email);
		session.setAttribute("user__id", user.getId());
		return "redirect:/albums";
	}
//	OLD LOGIN:
//	@PostMapping("/login")
//	public String login(@RequestParam("userToLogin") Long userId, HttpSession session ) {
//		session.setAttribute("user__id", userId); // Unique naming convention
//		// Hashmap is global to all endpoints
//		// userToLogin name is from the index.jsp
//		return "redirect:/albums";
//	}
	
	@GetMapping("/logout")
	public String logout(HttpSession session) {
		session.invalidate(); // Clear from session
		return "redirect:/"; // back to login
	}
	
	
	// Liking an album
	@GetMapping("/like/{id}")
	public String like(@PathVariable("id") Long id, HttpSession session) {
		// We need the user and which album to like
		Long UserId = (Long) session.getAttribute("user__id");
		Long albumId = id;
		User liker = this.uService.findOneUser(UserId);
		Album likedAlbum = this.aService.getOneAlbum(albumId);
		this.aService.addLiker(likedAlbum, liker);
		return "redirect:/albums";
	}
	
	// UnLiking an album
	@GetMapping("/unlike/{id}")
	public String unlike(@PathVariable("id") Long id, HttpSession session) {
		// We need the user and which album to like
		Long UserId = (Long) session.getAttribute("user__id");
		Long albumId = id;
		User liker = this.uService.findOneUser(UserId);
		Album likedAlbum = this.aService.getOneAlbum(albumId);
		this.aService.removeLiker(likedAlbum, liker);
		return "redirect:/albums";
	}
	
	
	@GetMapping("/albums")
	public String dashboard(Model viewModel, HttpSession session) { // was index before...
		// NEW CODE 
		if((Long) session.getAttribute("user__id") == null) {
			return "redirect:/"; // You must be logged int o do this
		}
		Long thisUser = (Long) session.getAttribute("user__id"); // Must typecast it, bc it's an object rn
		viewModel.addAttribute("user", this.uService.findOneUser(thisUser)); // Access to whoever is logged in
		// NEW CODE END
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
