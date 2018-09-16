package com.demo.configurations;

import java.io.IOException;
import java.util.Collection;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.web.DefaultRedirectStrategy;
import org.springframework.security.web.RedirectStrategy;
import org.springframework.security.web.authentication.AuthenticationSuccessHandler;
import org.springframework.stereotype.Component;

@Component
public class DefaultAuthenticationSuccessHandler implements AuthenticationSuccessHandler {

	private RedirectStrategy redirectStrategy = new DefaultRedirectStrategy();
	
	@Override
	public void onAuthenticationSuccess(HttpServletRequest request, HttpServletResponse response,
			Authentication authentication) throws IOException, ServletException {
		Collection<? extends GrantedAuthority> authorities = authentication.getAuthorities();
		for (GrantedAuthority grantedAuthority : authorities) {
			if(grantedAuthority.getAuthority().equalsIgnoreCase("SUPERADMIN")) {
				redirectStrategy.sendRedirect(request, response, "/superadmin/home");
			} else if(grantedAuthority.getAuthority().equalsIgnoreCase("COMPANYADMIN")) {
				redirectStrategy.sendRedirect(request, response, "/companyadmin/home");
			} else if(grantedAuthority.getAuthority().equalsIgnoreCase("AGENTADMIN")) {
				redirectStrategy.sendRedirect(request, response, "/agentadmin/home");
			} else {
				redirectStrategy.sendRedirect(request, response, "/user/home");
			}
		}
	}
}