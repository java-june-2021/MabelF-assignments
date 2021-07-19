package com.codingdojo.albums.controllers;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.codingdojo.albums.models.Album;
import com.codingdojo.albums.services.AlbumService;

@RestController
@RequestMapping("/api")
public class APIController {
	// Dependency injection
	@Autowired 
	private AlbumService aService;
	
	@GetMapping("") // If you use /api you need to not have a / here.
	public List<Album> allAlbums() {
		return this.aService.allAlbums();
	}

	@GetMapping("/id")
	public Album getOneAlbum(@PathVariable("id") Long id) {
		return this.aService.getOneAlbum(id);
	}
	
	@PostMapping("create")
	public Album createAlbum(Album album) {
		return this.aService.createAlbum(album);
	}
	
	@DeleteMapping("/delete/{id}")
	public void deleteAlbum(@PathVariable("id") Long id) {
		this.aService.deleteAlbum(id);
	}
	
	@PutMapping("/{id}")
	public void updateAlbum(@PathVariable("id") Long id, Album album) {
		this.aService.updateAlbum(album);
	}
}
