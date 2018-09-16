package com.demo.controllers.companyadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/companyadmin")
public class CompanyAdminController {

	@GetMapping("/home")
	public String home() {
		return "views/index";
	}
}