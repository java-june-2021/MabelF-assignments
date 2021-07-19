package com.codingdojo.dojooverflow.controllers;

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
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.codingdojo.dojooverflow.models.Answer;
import com.codingdojo.dojooverflow.models.Question;
import com.codingdojo.dojooverflow.models.Tag;
import com.codingdojo.dojooverflow.services.AnswerService;
import com.codingdojo.dojooverflow.services.QuestionService;
import com.codingdojo.dojooverflow.services.TagService;

@Controller
public class HomeController {
	@Autowired 
	private QuestionService qService;
	@Autowired
	private AnswerService aService;
	@Autowired
	private TagService tService;
	
	/** Question-specific Controllers */
	// General
	@GetMapping("/questions")
	public String newProduct(Model viewModel) {
		viewModel.addAttribute("allquestions", this.qService.allQuestions());
		return "/questions/dashboard.jsp";
	}

	/** NEW GET */
	@GetMapping("/questions/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "/questions/new.jsp";
	}

	/** NEW POST */
	// TODO what if this had the same path
	@PostMapping("/questions/addnew")
	public String addNewQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result, RedirectAttributes redirectAttr) {
		if (result.hasErrors()) {
			return "/questions/new.jsp"; //Rerender 
		}
		
		// TODO: why NPE if it didn't happen last time?
		String tags[] = question.getTagsList().split("\\s*,\\s*"); // Process tags
		Question newQuestion = this.qService.createQuestion(question); // Create Question . Below resulting in npe
		newQuestion.setTags(new ArrayList<>());
//		System.out.println("newquestionid:" + newQuestion.getId());
		for (String tag : tags) {
			Tag newTag = new Tag();
			newTag.setSubject(tag);
			if (!this.tService.findTag(tag)) {
				this.tService.createTag(newTag);
			}
			
			// TODO if it doesn't already exist , otherwise grab it from the database
			this.qService.addTagToQuestion(this.qService.getOneQuestion(newQuestion.getId()), newTag);
		}
		
		redirectAttr.addFlashAttribute("addSuccess", "Your question has been added.");
		return "redirect:/questions/new";
	}
	
	
	/** QUESTION PROFILE */
	@GetMapping("/questions/{question_id}")
	public String questionProfile(@PathVariable("question_id") Long id, @ModelAttribute("answer") Answer answer, Model viewModel) {
		viewModel.addAttribute("question", this.qService.getOneQuestion(id));		
		return "/questions/profile.jsp";
	}
	
	/** Submit answer */
	@PostMapping("/questions/{question_id}")
	public String addAnswer(@PathVariable("question_id") Long id, @Valid @ModelAttribute("answer") Answer answer, BindingResult result, RedirectAttributes redirectAttr) {
		if (result.hasErrors()) {
			return "/questions/profile.jsp"; //Rerender 
		}
		// TODO: it wasn't showing the answers and the question_id column was null, idk what to do
		answer.setQuestion(this.qService.getOneQuestion(id));
		this.aService.createAnswer(answer);
		this.qService.addAnswer(this.qService.getOneQuestion(id), answer);
		redirectAttr.addFlashAttribute("addSuccess", "Your answer has been added.");
		return "redirect:/questions/{question_id}";
	}
	
	
}
