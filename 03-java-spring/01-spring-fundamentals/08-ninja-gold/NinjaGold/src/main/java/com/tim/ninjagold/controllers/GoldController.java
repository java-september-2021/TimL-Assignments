package com.tim.ninjagold.controllers;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Random;

import javax.servlet.http.HttpSession;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class GoldController {
	@GetMapping("/")
	public String gold(Model viewModel, HttpSession session) {
		if (session.getAttribute("totalGold") == null) {
			session.setAttribute("totalGold", 0);
		}
		ArrayList<String> activity = new ArrayList<String>();
		if (session.getAttribute("activities") == null) {
			session.setAttribute("activities", activity);
		}
		viewModel.addAttribute("totalGold", session.getAttribute("totalGold"));
		viewModel.addAttribute("activitys", session.getAttribute("activities"));
		return "gold.jsp";
	}
	
	@PostMapping("/findGold")
	public String findGold(@RequestParam("building") String building, HttpSession session) {
		Random r = new Random();
		LocalDateTime now = LocalDateTime.now();
		DateTimeFormatter formatter = DateTimeFormatter.ofPattern("MMMM dd Y h:mma");
		ArrayList<String> activitys = (ArrayList<String>)session.getAttribute("activities");
		int goldThisTurn;
		if(building.equals("farm")) {
			goldThisTurn = r.nextInt((20 - 10) + 1) + 10;
			activitys.add(String.format("You entered a %s and earned %d gold. (%s)", building, goldThisTurn, formatter.format(now)));
		}else if(building.equals("cave")) {
			goldThisTurn = r.nextInt((10 - 5) + 1) + 5;
			activitys.add(String.format("You entered a %s and earned %d gold. (%s)", building, goldThisTurn, formatter.format(now)));
		}else if(building.equals("house")) {
			goldThisTurn = r.nextInt((5 - 2) + 1) + 2;
			activitys.add(String.format("You entered a %s and earned %d gold. (%s)", building, goldThisTurn, formatter.format(now)));
		}else if(building.equals("casino")) {
			goldThisTurn = r.nextInt((50 + 50) + 1) - 50;
			if(goldThisTurn < 0) {
				activitys.add(String.format("You entered a %s and lost %d gold, Ouch. (%s)", building, goldThisTurn, formatter.format(now)));
			}else {
				activitys.add(String.format("You entered a %s and earned %d gold. (%s)", building, goldThisTurn, formatter.format(now)));
			}
		}else {
			return"redirect:/";
		}
		int gold = (int)session.getAttribute("totalGold");
		int totalGold = gold += goldThisTurn;
		session.setAttribute("totalGold", totalGold);
		Collections.reverse(activitys);
		session.setAttribute("activities", activitys);
		return"redirect:/";
	}
}