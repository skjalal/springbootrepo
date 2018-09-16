package com.demo.controllers.superadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/superadmin")
public class SuperAdminController {
	
	@GetMapping("/home")
	public String home() {
		return "views/index";
	}
}