package com.rockplace.almond.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class UserController {

	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		String error = request.getParameter("error");
		if(error != null)
			return "error";
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return "login";
	}
	
	@GetMapping("/error")
	public String error(){
		return "error";
	}
}
