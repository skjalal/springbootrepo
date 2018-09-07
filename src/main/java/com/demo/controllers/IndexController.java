package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class IndexController {

	@GetMapping("/")
	public String login() {
		return "login";
	}

	@PostMapping("/index")
	public String index(Model model) {
		model.addAttribute("message", "Spring boot Application");
		return "views/index";
	}
}