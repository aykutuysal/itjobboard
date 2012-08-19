package aykutuysal.itjobboard.controller;

import java.security.Principal;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aykutuysal.itjobboard.dao.ApplicationDao;
import aykutuysal.itjobboard.service.ListingService;

@Controller
@RequestMapping("/listing")
@Transactional
public class ListingController {

	//private static final Logger logger = Logger.getLogger(ListingController.class);
	
	@Autowired
	ApplicationDao applicationDao;
	
	@Autowired
	ListingService listingService;
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String create(ModelMap model, Principal principal ) {
		return null;
	}
	
}
