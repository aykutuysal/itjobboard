package aykutuysal.jewel.controller;

import java.util.List;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.validation.BindingResult;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aykutuysal.jewel.model.dto.UserRegistration;
import aykutuysal.jewel.model.user.User;
import aykutuysal.jewel.service.UserService;


@Controller
@RequestMapping("/user")
public class UserController {

	@Autowired
	UserService userService;
	
	private static final Logger logger = Logger.getLogger(UserController.class);
	
	@RequestMapping(value="/register", method = RequestMethod.POST)
	public String register( @ModelAttribute @Valid UserRegistration userRegistration,
							BindingResult bindingResult,
							ModelMap model) {
		
		logger.debug("UserController#register() working");
		
		// check binding errors
		if(bindingResult.hasErrors()) {
			List<ObjectError> errors = bindingResult.getAllErrors();
			for(ObjectError error : errors) {
				logger.error("Object name : " + error.getObjectName());
				logger.error("Arguments : " + error.getArguments());
				logger.error("Default message : " + error.getDefaultMessage());
			}
			model.put("userRegistration", userRegistration);
			return "signup";
		}
	
		// check password and confirmPassword match
		if( !userRegistration.getPassword().equals(userRegistration.getConfirmPassword()) ) {
			model.addAttribute("passNotMatchError", true);
			return "signup";
		}
		
		User user = userRegistration.convertToUser();
		boolean registerResult = userService.registerUser(user);
		
		if( registerResult ) {
			logger.debug("Signup successful.");
			model.addAttribute("signupSuccess", true);
			return "signup";
		} else {
			model.addAttribute("duplicateEmailError", true);
			return "signup";
		}
		
	}
	
//
//	@RequestMapping(value="/name/{name}", method = RequestMethod.GET)
//	public @ResponseBody User getUser(@PathVariable("name") String name) {
//		System.out.println("geldi lan : " + name);
//		
//		User user = new User();
//		user.setEmail("aykutuysal444@gmail.com");
//		user.setFirstName("Aykut");
//		user.setLastName("Uysal");
//		user.setPassword("test");
//		user.setTitle("Mr");
//		user.setEnabled(true);
//
//		Resume r = new Resume();
//		r.setDescription("asdasd");
//		r.setPath("asdasd/asdasd/asdsad");
//		r.setTitle("asdasds");
//		r.setUser(user);
//		
//		List<Resume> resumes = new ArrayList<Resume>();
//		resumes.add(r);
//		
//		user.setResumes(resumes);
//		
//		userService.save(user);
//		return user;
//	}
//	
//	@RequestMapping(value="/addResume/{name}", method = RequestMethod.GET)
//	public @ResponseBody User addResume(@PathVariable("name") String name) {
//		System.out.println("geldi lan : " + name);
//		
//		User u = userService.addResume();
//		
//		return u;
//	}
//	
//	@RequestMapping(value="/get", method = RequestMethod.GET)
//	public @ResponseBody User get() {
//		User u = userService.getByEmail("aykutuysal444@gmail.com");
//		return u;
//	}

	
}