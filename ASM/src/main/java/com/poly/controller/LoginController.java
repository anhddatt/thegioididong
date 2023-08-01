package com.poly.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.poly.service.AccountRoleService;
import com.poly.service.AccountService;
import com.poly.service.SessionService;

@Controller
public class LoginController {
	@Autowired
	SessionService session;
	@Autowired
	AccountService accountService;
	@Autowired
	AccountRoleService accRoleService;

	@RequestMapping("/home/login")
	public String showPageLogin() {
		return "layout/_login";
	}

	@RequestMapping("/security/login/success")
	public String loginSuccess() {
		
		return "redirect:/";
	}
	@RequestMapping("/security/login/error")
	public String loginError() {
		return "layout/_login";
	}

	@RequestMapping("/security/logout")
	public String loginOut() {
		
		return "redirect:/";
	}

	@RequestMapping("/security/logout/success")
	public String loginOutSuccess() {
		return "redirect:/";
	}

//	@PostMapping("/login")
//	public String login(@RequestParam("username") String username, 
//						@RequestParam("password") String password,
//						RedirectAttributes redirectAttributes, Model model) {
//		
//		Optional<Account> user = accountService.findById(username);
//		if (!user.isPresent()) {
//			redirectAttributes.addFlashAttribute("loginMessage", "Tài khoản không tồn tại!");
//		} else if (user != null && user.get().getPassword().equals(password)) {
//			session.set("account", user.get());
//			redirectAttributes.addFlashAttribute("loginMessage", "Đăng nhập thành công!");	
//			return "/product/_list";
//		} else {
//			redirectAttributes.addFlashAttribute("loginMessage", "Mật khẩu sai!");
//			return "redirect:/home/login";
//		}
//		return "redirect:/home/login";
//		
//	}
//	

	@GetMapping("/logout")
	public String logout() {
		session.remove("account");
		return "redirect:/";
	}
}
