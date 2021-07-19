package com.codingdojo.dojooverflow.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.TagRepository;

@Service
public class TagService {
	@Autowired
	private TagRepository tRepo;
	

	// Display All 
	public List<Tag> allTags() {
		return this.tRepo.findAll();
	}
	
	// Create
	public Tag createTag(Tag tag) {
		return this.tRepo.save(tag);
	}
	
	// Read
	public Tag getOneTag(Long id) {
		return this.tRepo.findById(id).orElse(null);
	}
	
	// Update
	public Tag updateTag(Tag tag) {
		return this.tRepo.save(tag);
	}
	
	// Delete - Not required for this but here for good practice
	public String deleteTag(Long id) {
		this.tRepo.deleteById(id);
		return "Tag with this id: " + id + " has been deleted.";
 	}
	
	public boolean findTag(String subject) {
		return this.tRepo.existsBySubject(subject);
	}

}
