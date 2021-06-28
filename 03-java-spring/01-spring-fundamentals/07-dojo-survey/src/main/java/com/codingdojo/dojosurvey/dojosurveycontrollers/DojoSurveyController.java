package com.codingdojo.dojosurvey.dojosurveycontrollers;


import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

// Controller render links no view to view links

@Controller
public class DojoSurveyController {
	// This will be on localhost:8080
	@RequestMapping(path="/")
	public String index() {
		return "index.jsp";
	}
	
	
	@RequestMapping(path="/result", method=RequestMethod.POST)
	public String result(@RequestParam(value="name") String name, @RequestParam(value="location") String location, @RequestParam(value="language") String language, @RequestParam(value="comment") String comment, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("location", location);
		model.addAttribute("language", language);
		model.addAttribute("comment", comment);
		return "result.jsp";
	}
	
}


