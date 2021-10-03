package com.tim.dojoandninjas.controllers;

import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.tim.dojoandninjas.models.Dojo;
import com.tim.dojoandninjas.models.Ninjas;
import com.tim.dojoandninjas.services.DojoAndNinjasService;

@Controller
@RequestMapping("/ninjas")
public class NinjasController {
	@Autowired
	private DojoAndNinjasService danService;
	
	@GetMapping("/new")
	public String addNinja(@ModelAttribute("ninja") Ninjas ninja, Model viewModel) {
		List<Dojo> allDojos = this.danService.allDojos();
		viewModel.addAttribute("allDojos", allDojos);
		return "NewNinja.jsp";
	}
	
	@PostMapping("/createNinja")
	public String crateNinja(@Valid @ModelAttribute("ninja") Ninjas ninja, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			List<Dojo> allDojos = this.danService.allDojos();
			viewModel.addAttribute("allDojos", allDojos);
			return "NewNinja.jsp";
		}
		this.danService.createNinja(ninja);
		return "redirect:/dojos/" + ninja.getDojo().getId();
	}
	
	
	
}