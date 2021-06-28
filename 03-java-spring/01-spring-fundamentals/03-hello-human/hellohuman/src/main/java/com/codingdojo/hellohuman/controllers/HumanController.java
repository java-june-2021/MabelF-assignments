package com.codingdojo.hellohuman.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class HumanController {
	@RequestMapping("/")
	public String index(@RequestParam(value="name", defaultValue = "Human", required=false) String name, @RequestParam(value="lastName", defaultValue = "", required=false) String lastName, Model model) {
		model.addAttribute("name", name);
		model.addAttribute("lastName", lastName);
		return "index.jsp";
	}

}
