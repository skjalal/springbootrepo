package com.demo.controllers.superadmin;

import java.security.Principal;
import java.util.Date;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import com.demo.entities.Company;
import com.demo.entities.Role;
import com.demo.entities.StatusMain;
import com.demo.entities.UserRegistration;
import com.demo.services.CompanyService;
import com.demo.services.ILoggedInUser;
import com.demo.services.RoleService;
import com.demo.services.StatusMainService;
import com.demo.services.UserRegistrationService;

@Controller
@RequestMapping(value = "/superadmin")
public class SuperAdminController {

	@Autowired
	private ILoggedInUser loggedInUser;

	@Autowired
	private UserRegistrationService userRegistrationService;

	@Autowired
	private StatusMainService statusMainService;

	@Autowired
	private CompanyService companyService;

	@Autowired
	private BCryptPasswordEncoder bCryptPasswordEncoder;

	@Autowired
	private RoleService roleService;

	@RequestMapping(value = "/dashboard", method = { RequestMethod.GET, RequestMethod.POST })
	public String home() {
		return "superadmin/dashboard";
	}

	@GetMapping("/changePwd")
	public String changePwd() {
		return "superadmin/changePwd";
	}

	@PostMapping("/changePwd")
	public String changePwd(Model model, @RequestParam String oldPassword, @RequestParam String newPassword,
			@RequestParam String cnfNewPassword, Principal principal) {
		UserRegistration user = loggedInUser.getLoggedInUser(principal.getName());
		boolean oldPasswordCheck = bCryptPasswordEncoder.matches(oldPassword, user.getPassword());
		if (!oldPasswordCheck) {
			model.addAttribute("passwordnotfound", "Old password did'nt matched");
		} else {
			if (newPassword.equals(cnfNewPassword)) {
				String encodedPassword = bCryptPasswordEncoder.encode(newPassword);
				user.setPassword(encodedPassword);
				userRegistrationService.save(user);
				model.addAttribute("passwordchanged", "Password is changed successfully");
			} else {
				model.addAttribute("passwordnotfound", "New and confirm password should be same");
			}
		}
		return "superadmin/changePwd";
	}

	@GetMapping("/register")
	public String register() {
		return "superadmin/register";
	}

	@PostMapping("/register")
	public String register(Model model, @ModelAttribute Company company, BindingResult bindingResult,
			Principal principal) {
		if (bindingResult.hasErrors()) {
			return "redirect:/superadmin/register?error=true";
		}
		Company findByCode = companyService.findByCode(company.getCode());
		Company findByCompanyName = companyService.findByCompanyName(company.getCompanyName());
		Company findByEmail = companyService.findByEmail(company.getEmail());
		boolean flag = true;
		if (findByCode != null) {
			flag = false;
		} else if (findByCompanyName != null) {
			flag = false;
		} else if (findByEmail != null) {
			flag = false;
		}
		if (!flag) {
			return "redirect:/superadmin/register?error=true";
		}
		UserRegistration user = loggedInUser.getLoggedInUser(principal.getName());
		StatusMain statusMain = statusMainService.findById(new Integer(1));
		company.setCreatedBy(user);
		company.setLastModifiedBy(user);
		company.setCreatedDate(new Date());
		company.setLastModifiedDate(new Date());
		company.setStatusMain(statusMain);
		companyService.save(company);
		UserRegistration newuser = new UserRegistration();
		String encodePassword = bCryptPasswordEncoder.encode("test");
		Role role = roleService.findByRole("COMPANYADMIN");
		newuser.setStatusMain(statusMain);
		newuser.setPassword(encodePassword);
		newuser.setUserName(company.getEmail().trim());
		newuser.setFirstName(company.getName());
		newuser.setCompanyId(company.getCompanyId());
		newuser.setDefaultCompanyId(company.getCompanyId());
		newuser.setPrivilege("privileges");
		newuser.setTypeId(company.getCompanyId());
		newuser.setTypeName("Company");
		newuser.setRole(role);
		userRegistrationService.save(newuser);
		return "redirect:/superadmin/dashboard?success=true";
	}
}