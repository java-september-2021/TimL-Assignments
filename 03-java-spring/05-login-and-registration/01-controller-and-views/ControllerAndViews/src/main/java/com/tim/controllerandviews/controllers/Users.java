package com.tim.controllerandviews.controllers;

import javax.servlet.http.HttpSession;
import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.tim.controllerandviews.models.User;
import com.tim.controllerandviews.services.UserService;

@Controller
public class Users {
	@Autowired
	private UserService userService;

	//private final UserService userService;
	 
	public Users(UserService userService) {
		this.userService = userService;
	}
 
	@RequestMapping("/registration")
	public String registerForm(@ModelAttribute("user") User user) {
		return "registrationPage.jsp";
	}
	
	@RequestMapping("/login")
	public String login() {
		return "loginPage.jsp";
	}
 
	@RequestMapping(value="/registration", method=RequestMethod.POST)
	public String registerUser(@Valid @ModelAttribute("user") User user, BindingResult result, HttpSession session) {
	 // if result has errors, return the registration page (don't worry about validations just now)
		if(result.hasErrors());{
			return "registrationPage.jsp";
		}
	 // else, save the user in the database, save the user id in session, and redirect them to the /home route
		User u = userService.registerUser(user);
		session.setAttribute("userId", u.getId());
		return "redirect:/home";
	}
	
	@RequestMapping(value="/login", method=RequestMethod.POST)
	public String loginUser(@RequestParam("email") String email, @RequestParam("password") String password, Model model, HttpSession session) {
     // if the user is authenticated, save their user id in session
		boolean isAuthenticated = userService.authenticateUser(email, password);
		if(isAuthenticated) {
			User u = userService.findByEmail(email); 
			session.setAttribute("userId", u.getId());
			return "redirect:/home";
		}
     // else, add error messages and return the login page
		else {
			model.addAttribute("error", "Invalid Credential. Please try again.");
			return "loginPage.jsp";
		}
	}
 
	@RequestMapping("/home")
	public String home(HttpSession session, Model model) {
     // get user from session, save them in the model and return the home page
		Long userId = (Long) session.getAttribute("userId");
		User u = userService.findUserById(userId);
		model.addAttribute("user", u);
		return "homePage.jsp";
	}
	
	@RequestMapping("/logout")
	public String logout(HttpSession session) {
     // invalidate session
		session.invalidate();
     // redirect to login page
		return "redirect:/login";
	}
}
