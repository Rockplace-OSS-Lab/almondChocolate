package com.rockplace.almond.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;

@Controller
public class UserController {

	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		String error = request.getParameter("error");
		if(error != null)
			return "loginFail";
		
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return "login";
	}
	
	@GetMapping("/error")
	public String error(){
		return "error";
	}
	@PostMapping("/loginProcess")
	public String loginProcess(){
		return "loginProcess";
	}
}
