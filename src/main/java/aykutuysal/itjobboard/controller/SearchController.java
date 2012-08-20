package aykutuysal.itjobboard.controller;

import java.util.ArrayList;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import aykutuysal.itjobboard.model.LocationAutoComplete;

@Controller
@RequestMapping("/search")
public class SearchController {

	private static final Logger logger = Logger.getLogger(SearchController.class);

	@RequestMapping(value="/", method = RequestMethod.GET)
	public String search(String keywords, String locations) {
		logger.debug("keywords : " + keywords);
		logger.debug("locations : " + locations);
		return "search";
	}
	
	@RequestMapping(value="/locationAutoComplete", method = RequestMethod.GET)
	public @ResponseBody List<LocationAutoComplete> getUser(String q) {
		
		logger.debug("q : " + q);
		
		List<LocationAutoComplete> list = new ArrayList<LocationAutoComplete>();
		list.add(new LocationAutoComplete("1", "Istanbul"));
		list.add(new LocationAutoComplete("2", "Ankara"));
		list.add(new LocationAutoComplete("3", "Antalya"));
		list.add(new LocationAutoComplete("4", "Adana"));
		
		return list;
	}
	
}
