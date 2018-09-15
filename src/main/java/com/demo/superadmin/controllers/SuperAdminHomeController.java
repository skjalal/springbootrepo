package com.demo.superadmin.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/superadmin")
public class SuperAdminHomeController {

	@GetMapping("/home")
	public String home() {
		return "views/index";
	}
}