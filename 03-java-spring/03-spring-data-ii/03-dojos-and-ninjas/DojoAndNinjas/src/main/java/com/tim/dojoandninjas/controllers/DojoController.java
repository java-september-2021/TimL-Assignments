package com.tim.dojoandninjas.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tim.dojoandninjas.models.Dojo;
import com.tim.dojoandninjas.services.DojoAndNinjasService;

@Controller
@RequestMapping("/dojos")
public class DojoController {
	@Autowired
	private DojoAndNinjasService danService;
	
	@GetMapping("/new")
	public String createDojo(@ModelAttribute("dojo") Dojo dojo) {
		return "NewDojo.jsp";
	}
	
	@PostMapping("/createDojo")
	public String dojoCreate(@Valid @ModelAttribute("dojo") Dojo dojo, BindingResult result) {
		if(result.hasErrors()) {
			return "NewDojo.jsp";
		}
		this.danService.createDojo(dojo);
		return "redirect:/ninjas/new";
	}
	
	@GetMapping("/{id}")
	public String showDojo(Model viewModel, @PathVariable("id") Long id) {
		viewModel.addAttribute("dojo", this.danService.getOneDojo(id));
		return "DojoPage.jsp";
	}
	
}
