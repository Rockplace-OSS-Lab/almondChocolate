package almond.controller;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import almond.domain.EmailTemplete;
import almond.domain.User;
import almond.service.MailService;
import almond.service.UserService;

@Controller
@RequestMapping("/users")
public class UserController {

	@Autowired
	private MailService mailService;

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
		return "registration";
	}

	@PostMapping("/registration")
	public String registrationProcess(User user, EmailTemplete emailTemplete) {
		
		// 유저 등록
		userService.registrationProcess(user);
		// 승인 url 생성
		String contents = emailTemplete.contents(user);
		// 메일 발송
		mailService.sendMail(user.getEmail(), "승인요청메일", contents);

		return "redirect:/users/registration";
	}

	@GetMapping("/registration_ok")
	public String registrationOk(@RequestParam String email, @RequestParam String okKey) {
		try {
			// 이메일&키 일치 시 승인 처리(status=1)
			userService.registrationOk(email, okKey);
		} catch (Exception e) {
			e.printStackTrace();
		}
		
		return "registration_ok";
	}
}
