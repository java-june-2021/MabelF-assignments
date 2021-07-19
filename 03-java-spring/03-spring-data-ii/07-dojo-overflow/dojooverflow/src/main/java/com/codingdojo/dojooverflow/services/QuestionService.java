package com.codingdojo.dojooverflow.services;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.repositories.QuestionRepository;

@Service
public class QuestionService {
	@Autowired
	private QuestionRepository qRepo;
	

	// Display All 
	public List<Question> allQuestions() {
		return this.qRepo.findAll();
	}
	
	// Create
	public Question createQuestion(Question question) {
		return this.qRepo.save(question);
	}
	
	// Read
	public Question getOneQuestion(Long id) {
		return this.qRepo.findById(id).orElse(null);
	}
	
	// Update
	public Question updateQuestion(Question question) {
		return this.qRepo.save(question);
	}
	
	// Delete - Not required for this but here for good practice
	public String deleteQuestion(Long id) {
		this.qRepo.deleteById(id);
		return "Question with this id: " + id + " has been deleted.";
 	}
	
	// NEW: Add a tag to a question
	public void addTagToQuestion(Question question, Tag tag) {
		// Use this only after you've checked the database for the tag and it's either there or done being added
		// TODO NULL POINTER EXCEPTION
		List<Tag> currentTags = question.getTags();
		if (!question.getTags().contains(tag)) {
			currentTags.add(tag);
		}
		
		this.qRepo.save(question);
	}
	
	// NEW: Add an answer to a question
	public void addAnswer(Question question, Answer answer) {
		List<Answer> currentAnswers = question.getAnswers();
		currentAnswers.add(answer);
		this.qRepo.save(question);
		
	}

}
