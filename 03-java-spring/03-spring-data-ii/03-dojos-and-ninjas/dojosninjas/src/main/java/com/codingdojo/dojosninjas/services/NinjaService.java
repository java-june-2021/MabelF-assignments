package com.codingdojo.dojosninjas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Ninja;
import com.codingdojo.dojosninjas.repositories.NinjaRepository;

@Service
public class NinjaService {
	@Autowired
	private NinjaRepository nRepo;
	
	public Ninja create(Ninja ninja) {
		return this.nRepo.save(ninja);
	}
	
	public void delete(Long id) {
		this.nRepo.deleteById(id);
	}
}
