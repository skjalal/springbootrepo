package com.demo.controllers.agentadmin;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping(value = "/agentadmin")
public class AgentAdminController {

	@GetMapping("/home")
	public String home() {
		return "views/index";
	}
}