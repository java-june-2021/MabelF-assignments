package com.codingdojo.albums.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.albums.models.Song;
import com.codingdojo.albums.repositories.SongRepository;

@Service
public class SongService {
	@Autowired
	private SongRepository sRepo;
	
	public Song create(Song song) {
		return this.sRepo.save(song);
	}
	
	public void delete(Long id) {
		this.sRepo.deleteById(id);
	}
}

