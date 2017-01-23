package fr.imie.spring.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import fr.imie.spring.entity.User;
import fr.imie.spring.repository.UserRepository;

@Controller
public class LoginController {
	// private static final String VALID_LOGIN="Toto";
	// private static final String VALID_PASSWORD="toto22";

	protected UserRepository userRepository;

	@Autowired
	public LoginController(UserRepository userRepo) {
		this.userRepository = userRepo;
	}

	@RequestMapping(method = RequestMethod.GET, path = "/login")
	public String login(Model model) {
		return "connect";
	}

	@RequestMapping(method = RequestMethod.POST, path = "/checkLogin")
	public String checkLogin(
			@RequestParam(value = "login", required = false) 
			String login,
			@RequestParam(value = "password", required = false) 
			String password, 
			Model model
			) {

			User user = this.userRepository.findByLogin(login);

			if (user != null && 
				user.getPassword().equals(password)) {
				model.addAttribute("login", login);
				return "home";
			}
				model.addAttribute("fail", true);
				return "connect";
			
	}

	@RequestMapping(method = RequestMethod.GET, path = "/logout")
	public String logout(Model model) {
		return "connect";
	}

	@RequestMapping(method = RequestMethod.GET, path = "/reset")
	public String resetPassword(Model model) {
		return null;
	}
}
