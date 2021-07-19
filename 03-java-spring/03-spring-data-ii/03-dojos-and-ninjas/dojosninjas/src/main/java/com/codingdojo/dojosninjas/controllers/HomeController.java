package com.codingdojo.dojosninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.codingdojo.dojosninjas.models.Dojo;
import com.codingdojo.dojosninjas.models.Ninja;
import com.codingdojo.dojosninjas.services.DojoService;
import com.codingdojo.dojosninjas.services.NinjaService;

@Controller
public class HomeController {
//	 Dependency injection
	@Autowired 
	private DojoService dService;
	@Autowired 
	private NinjaService nService;

	
	/** Form to add new dojo */
	@GetMapping("/dojos/new")
	public String index(@ModelAttribute("dojo") Dojo dojo, Model viewModel) {
//		viewModel.addAttribute("dojo", new Dojo()); // TODO why
		return "/dojos/new.jsp";
	}
	
	@PostMapping("/dojos/addDojo")
	public String addDojoJSTL(@Valid @ModelAttribute("album") Dojo dojo, BindingResult  result) {
		if (result.hasErrors()) {
			return "/dojos/new.jsp"; //Rerender 
		}
		this.dService.createDojo(dojo);
		return "redirect:/dojos/new";
	}
	

	/** To add new ninjas - can break this into its own NinjaController later -------------------------------- */
	@GetMapping("/ninjas/new")
	public String createNinja(@ModelAttribute("ninja") Ninja ninja, Model viewModel) {
		viewModel.addAttribute("dojos", this.dService.allDojos());
		return "/ninjas/newninja.jsp";
		
	}
	
	@PostMapping("/ninjas/add")
	public String addNinja(@Valid @ModelAttribute("ninja") Ninja ninja, BindingResult result, Model viewModel) {
		Long dojoId = ninja.getDojo().getId(); // Use the setter
		if (result.hasErrors()) {
			viewModel.addAttribute("dojos", this.dService.allDojos());
			return "/ninjas/newninja.jsp";
		}
		this.nService.create(ninja);
		return "redirect:/ninjas/new"; // This line issues a get Request
	}

	
	/** To view a specific dojo's ninjas -------------------------------------------------------------------- */
	@GetMapping("/dojos/{dojoId}")
	public String viewDojo(@PathVariable("dojoId") Long id, Model viewModel) {
		viewModel.addAttribute("dojo", this.dService.getOneDojo(id));
		viewModel.addAttribute("ninjas", this.dService.getOneDojo(id).getNinjas());
		return "/dojos/dojopage.jsp";
		
	}
	
	
	
}
