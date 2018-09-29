package com.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class LoginController {

	@GetMapping(value = { "/", "/login" })
	public String login() {
		return "login";
	}
	
	@GetMapping("/forgotPassword")
	public String forgotPassword() {
		return "forgotPwd";
	}
	
	@PostMapping("/forgotPassword")
	public String forgotPassword(@RequestParam String email, Model model) {
		model.addAttribute("forgotPwdMessage","New password sent to registered email.");
		return "forgotPwd";
	}
}