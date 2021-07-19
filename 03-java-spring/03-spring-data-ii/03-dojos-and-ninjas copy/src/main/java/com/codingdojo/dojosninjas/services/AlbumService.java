package com.codingdojo.dojosninjas.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Album;
import com.codingdojo.dojosninjas.repositories.AlbumRepository;

@Service
public class AlbumService { // Dependency injection
	private AlbumRepository aRepo;
	public AlbumService(AlbumRepository aRepo) {
		this.aRepo = aRepo;
	}
	
	// Display All Albums
	public List<Album> allAlbums() {
		return this.aRepo.findAll();
	}
	
	// Create
	public Album createAlbum(Album album) {
		return this.aRepo.save(album);
	}
	
	// Read
	public Album getOneAlbum(Long id) {
		return this.aRepo.findById(id).orElse(null);
	}
	
	// Update
	public Album updateAlbum(Album album) {
		return this.aRepo.save(album);
	}
	
	// Delete
	public String deleteAlbum(Long id) {
		this.aRepo.deleteById(id);
		return "Album " + id + " has been deleted.";
 	}
	
	
}
