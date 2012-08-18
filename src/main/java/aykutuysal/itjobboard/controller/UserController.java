package aykutuysal.itjobboard.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import aykutuysal.itjobboard.model.User;
import aykutuysal.itjobboard.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register(	ModelMap model,
							String email,
							String password ) {
		
		System.out.println("email : " + email);
		System.out.println("password : " + password);
		
		// check if a user with same email exists
		User u = userService.getByEmail(email);
		if( u == null ) {
			User user = new User();
			user.setEmail(email);
			user.setPassword(password);
			user.setEnabled(true);
			
			userService.save(user);
			model.addAttribute("signupSuccess", true);
			return "signup";
		} else {
			model.addAttribute("duplicateEmailError", true);
			return "signup";
		}
	}
	
	@RequestMapping(value="/name/{name}", method = RequestMethod.GET)
	public @ResponseBody User getUser(@PathVariable String name) {
		System.out.println("geldi lan : " + name);
		
		User user = new User();
		user.setEmail("aykutuysal@gmail.com");
		user.setFirstName("Aykut");
		user.setLastName("Uysal");
		user.setPassword("test");
		user.setEnabled(true);

		userService.save(user);
		return user;
	}
	

	
}