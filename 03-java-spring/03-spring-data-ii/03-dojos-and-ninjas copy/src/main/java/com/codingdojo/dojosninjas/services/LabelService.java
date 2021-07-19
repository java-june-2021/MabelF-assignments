package com.codingdojo.dojosninjas.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojosninjas.models.Label;
import com.codingdojo.dojosninjas.repositories.LabelRepository;

@Service
public class LabelService {
	@Autowired
	private LabelRepository lRepo;
	
	public Label createLabel(Label label) {
		return this.lRepo.save(label);
	}

}
