package aykutuysal.jewel.controller;

import java.security.Principal;
import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import aykutuysal.jewel.model.dto.JewelryForm;
import aykutuysal.jewel.model.jewelry.Jewelry;
import aykutuysal.jewel.service.JewelryService;
import aykutuysal.jewel.util.ImageUtils;

@Controller
@RequestMapping("/jewelry")
public class JewelryController {

	private static final Logger logger = Logger.getLogger(JewelryController.class);
	
	@Autowired
	JewelryService jewelryService;
	
	@Value("${image.upload.path}")
	String imageUploadPath;
	
	@RequestMapping(method = RequestMethod.POST)
	public String save(@ModelAttribute JewelryForm jewelryForm, Principal principal, ModelMap model) {

		if (principal != null) {
			logger.info("logged in as " + principal.getName());
		}
		
		Jewelry jewelry = jewelryForm.convertToJewelry();
		String imagePath = ImageUtils.saveImage(jewelryForm.getImageData(), imageUploadPath);
		jewelry.setImagePath(imagePath);
		jewelryService.save(jewelry);
		
		model.put("jewelries", jewelryService.loadAll());
		model.put("jewelryAddSuccessful", true);
		return "jewelryList";
	}
	
	@RequestMapping(value="/list", method = RequestMethod.GET)
	public String list(ModelMap model, Principal principal ) {

		if (principal != null) {
			logger.info("logged in as " + principal.getName());
		}
		
		List<Jewelry> jewelries = jewelryService.loadAll();
		model.put("jewelries", jewelries);
		
		return "jewelryList";
	}
	
	@RequestMapping(value="/add", method = RequestMethod.GET)
	public String showSavePage(ModelMap model, Principal principal ) {

		if (principal != null) {
			logger.info("logged in as " + principal.getName());
		}
		model.put("jewelryForm", new JewelryForm());
		return "addJewelry";
	}
}

