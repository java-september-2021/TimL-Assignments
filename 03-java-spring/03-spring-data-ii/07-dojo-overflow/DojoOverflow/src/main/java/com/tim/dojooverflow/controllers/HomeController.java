package com.tim.dojooverflow.controllers;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;

import com.tim.dojooverflow.models.Answer;
import com.tim.dojooverflow.models.Question;
import com.tim.dojooverflow.services.OverflowService;
import com.tim.dojooverflow.validators.TagValidator;

@Controller
public class HomeController {
	@Autowired
	private OverflowService oService;
	@Autowired
	private TagValidator tValidator;
	
	@GetMapping("/")
	public String index (Model viewModel) {
		viewModel.addAttribute("allquestions", this.oService.getAllQuestion());
		return "dashboard.jsp";
	}

	@GetMapping("/new")
	public String newQuestion(@ModelAttribute("question") Question question) {
		return "newQuestion.jsp";
	}
	
	@PostMapping("/newQuestion")
	public String addQuestion(@Valid @ModelAttribute("question") Question question, BindingResult result) {
		tValidator.validate(question, result);
		if(result.hasErrors()) {
			return "newQuestion.jsp";
		}
		this.oService.createQuestion(question);
		return "redirect:/";
	}
	
	@GetMapping("/questionProfile/{id}")
	public String questionProfile(@PathVariable("id") Long id, Model viewModel, @ModelAttribute("answer") Answer answer) {
		viewModel.addAttribute("question", this.oService.getOneQuestion(id));
		return "questionProfile.jsp";
	}
	
	@PostMapping("/addAnswer")
	public String addAnswer(@Valid @ModelAttribute("answer") Answer answer, BindingResult result, Model viewModel) {
		if(result.hasErrors()) {
			viewModel.addAttribute("question", this.oService.getOneQuestion(answer.getQuest().getId()));
			return "questionProfile.jsp";
		}
		this.oService.createAnswer(answer);
		return "redirect:/questionProfile/" + answer.getQuest().getId();
	}
	
	
	
	
}
