package aykutuysal.itjobboard.controller;

import java.security.Principal;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
public class HomeController {

	private static final Logger logger = Logger.getLogger(HomeController.class);
	
	
	@RequestMapping(value="/", method = RequestMethod.GET)
	public String home(ModelMap model, Principal principal ) {

		if (principal != null) {
			logger.info("logged in as " + principal.getName());
		}
		
		return "index";
	}
}
