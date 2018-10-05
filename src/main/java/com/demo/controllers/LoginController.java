package com.demo.controllers;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.UserRegistration;
import com.demo.services.UserRegistrationService;
import com.sendgrid.Content;
import com.sendgrid.Email;
import com.sendgrid.Mail;
import com.sendgrid.Method;
import com.sendgrid.Request;
import com.sendgrid.Response;
import com.sendgrid.SendGrid;

@Controller
public class LoginController {

	@Autowired
	private SendGrid sendGrid;
	
	@Autowired
	private UserRegistrationService userRegistrationService;
	
	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@GetMapping(value = { "/", "/login" })
	public String login() {
		return "login";
	}

	@GetMapping("/forgotPassword")
	public String forgotPassword() {
		return "forgotPwd";
	}

	@PostMapping("/forgotPassword")
	public String forgotPassword(@RequestParam String email, Model model, HttpServletRequest req) {
		Email from = new Email("sk.jalal46@gmail.com");
		String subject = "Password Reset Request";
		Email to = new Email(email);
		String url = req.getRequestURL().toString();
		url = url.replace("/forgotPassword", "");
		Content content = new Content("text/plain", "To reset your password, click the link below:\n"+url+"/reset?email="+email.trim());
		Mail mail = new Mail(from, subject, to, content);
		Request request = new Request();
		try {
			request.setMethod(Method.POST);
			request.setEndpoint("mail/send");
			request.setBody(mail.build());
			Response response = sendGrid.api(request);
			System.out.println("Status Code: " + response.getStatusCode() + ", Body: " + response.getBody()
					+ ", Headers: " + response.getHeaders());
		} catch (Exception e) {
			e.printStackTrace();
		}
		model.addAttribute("forgotPwdMessage", "A password reset link has been sent to "+email);
		return "forgotPwd";
	}
	
	@GetMapping("/reset")
	public String resetPassword(@RequestParam String email, Model model) {
		UserRegistration userRegistration = userRegistrationService.findByUserName(email);
		if(userRegistration == null) {
			return "redirect:/login?error=true";
		} else {
			model.addAttribute("email",email);
		}
		return "resetForm";
	}
	
	@PostMapping("/reset")
	public String resetPassword(Model model, @RequestParam String email, @RequestParam String newPassword,
			@RequestParam String cnfNewPassword) {
		try {
			UserRegistration user = userRegistrationService.findByUserName(email);
			if (newPassword.equals(cnfNewPassword)) {
				String encodedPassword = bCryptPasswordEncoder.encode(newPassword);
				user.setPassword(encodedPassword);
				userRegistrationService.save(user);
			} else {
				model.addAttribute("passwordnotfound", "New and confirm password should be same");
				return "resetForm";
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return "redirect:/login?password=true";
	}
}