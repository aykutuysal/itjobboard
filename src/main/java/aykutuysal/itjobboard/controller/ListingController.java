package aykutuysal.itjobboard.controller;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import aykutuysal.itjobboard.dao.ApplicationDao;
import aykutuysal.itjobboard.dao.ListingDao;
import aykutuysal.itjobboard.model.Application;
import aykutuysal.itjobboard.model.Listing;
import aykutuysal.itjobboard.service.ListingService;

@Controller
@RequestMapping("/listing")
@Transactional
public class ListingController {

	private static final Logger logger = Logger.getLogger(ListingController.class);
	
	@Autowired
	ApplicationDao applicationDao;
	
	@Autowired
	ListingService listingService;
	
	@RequestMapping(value="/create", method = RequestMethod.POST)
	public String create(ModelMap model, Principal principal ) {
		return null;
	}
	
}
