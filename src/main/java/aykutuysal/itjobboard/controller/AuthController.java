package aykutuysal.itjobboard.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aykutuysal.itjobboard.model.User;


@Controller
public class AuthController {

	private static final Logger logger = Logger.getLogger(AuthController.class);

	@RequestMapping(value="/me", method = RequestMethod.GET)
	public String me(ModelMap model, Principal principal ) {
		String name = principal.getName();
		logger.info("My account page requested for: " + name);
		return "me";
	}

	@RequestMapping(value="/signin", method = RequestMethod.GET)
	public String signin(ModelMap model) {
		return "signin";
	}
	
	@RequestMapping(value="/signup", method = RequestMethod.GET)
	public String signup(ModelMap model) {
		logger.info("AuthController#signup() working");
		model.put("user", new User());
		return "signup";
	}

	@RequestMapping(value="/authfail", method = RequestMethod.GET)
	public String authFail(ModelMap model) {
		model.addAttribute("signinError", "true");
		return "signin";
	}

	@RequestMapping(value="/signout", method = RequestMethod.GET)
	public String signout(ModelMap model) {
		return "index";
	}
	
}