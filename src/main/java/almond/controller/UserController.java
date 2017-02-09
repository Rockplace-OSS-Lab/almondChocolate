package almond.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import almond.domain.User;
import almond.service.UserService;

@Controller
public class UserController {
	@Autowired
	private UserService userService;
	
	@GetMapping("/login")
	public String login(HttpServletRequest request) {
		Authentication authentication = SecurityContextHolder.getContext().getAuthentication();
		return "login";
	}

	@GetMapping("/error")
	public String error() {
		return "error";
	}

	@PostMapping("/loginProcess")
	public String loginProcess(HttpServletRequest request) {
		request.setAttribute("loginCheck", "true");
		return "loginProcess";
	}

	@GetMapping("/logout")
	public String logout() {
		return "login";
	}

	@GetMapping("/loginFail")
	public String loginFail() {
		return "loginFail";
	}

	@GetMapping("/registration")
	public String registration() {
		return "/registration";
	}

	@PostMapping("/registration")
	public String registrationProcess(User user) throws Exception {
		// 유저 등록
		userService.registrationProcess(user);

		return "redirect:/registration";
	}

	@GetMapping("/registration_ok")
	public String registrationOk(@RequestParam String email, @RequestParam String okKey) {
		try {
			// 이메일&키 일치 시 승인 처리(status=1)
			userService.registrationOk(email, okKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "redirect:/";
	}
}
