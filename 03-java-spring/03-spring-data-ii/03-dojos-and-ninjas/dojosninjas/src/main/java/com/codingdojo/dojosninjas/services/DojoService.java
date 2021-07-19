package com.codingdojo.dojosninjas.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.repositories.DojoRepository;

//import com.codingdojo.albums.models.Album;
//import com.codingdojo.albums.repositories.AlbumRepository;


@Service
public class DojoService {
	@Autowired
	private DojoRepository dRepo;
	public DojoService(DojoRepository dRepo) {
		this.dRepo = dRepo;
	}
	
	// Display All 
	public List<Dojo> allDojos() {
		return this.dRepo.findAll();
	}
	
	// Create
	public Dojo createDojo(Dojo album) {
		return this.dRepo.save(album);
	}
	
	// Read
	public Dojo getOneDojo(Long id) {
		return this.dRepo.findById(id).orElse(null);
	}
	
	// Update
	public Dojo updateDojo(Dojo album) {
		return this.dRepo.save(album);
	}
	
	// Delete
	public String deleteDojo(Long id) {
		this.dRepo.deleteById(id);
		return "Dojo " + id + " has been deleted.";
 	}

}

