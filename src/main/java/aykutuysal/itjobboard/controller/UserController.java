package aykutuysal.itjobboard.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
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
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register( @ModelAttribute @Valid User user,
							BindingResult bindingResult,
							ModelMap model) {
		logger.debug("UserController#register() working");
		
		if(bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			for(ObjectError error : errors) {
				System.out.println("Object name : " + error.getObjectName());
				System.out.println("Arguments : " + error.getArguments());
				System.out.println("Default message : " + error.getDefaultMessage());
			}
			model.put("user", user);
			return "signup";
		} 
		
		User u = userService.getByEmail(user.getEmail());
		if( u == null ) {
			userService.save(user);
			model.addAttribute("signupSuccess", true);
			return "signup";
		} else {
			model.addAttribute("duplicateEmailError", true);
			return "signup";
		}	
		
		
		
		//System.out.println(user);
		//System.out.println(errors.getAllErrors());
		
//		System.out.println("modelmap: " + model);
//		System.out.println("email: " + email);
//		System.out.println("pass: " + password);
//		System.out.println("title: " + title);
//		System.out.println("firstname: " + firstName);
//		System.out.println("lastname: " + lastName);
//		System.out.println("phone: " + phone);
//		
//		return "signup";
//		
//		System.out.println("email : " + email);
//		System.out.println("password : " + password);
//		
//		// check if a user with same email exists
//		User u = userService.getByEmail(email);
//		if( u == null ) {
//			User user = new User();
//			user.setEmail(email);
//			user.setPassword(password);
//			user.setEnabled(true);
//			
//			userService.save(user);
//			model.addAttribute("signupSuccess", true);
//			return "signup";
//		} else {
//			model.addAttribute("duplicateEmailError", true);
//			return "signup";
//		}
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