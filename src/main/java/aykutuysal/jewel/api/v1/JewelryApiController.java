package aykutuysal.jewel.api.v1;

import java.util.List;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import aykutuysal.jewel.model.jewelry.Jewelry;
import aykutuysal.jewel.service.JewelryService;

@Controller
@RequestMapping("/api/v1/jewelry")
public class JewelryApiController extends AbstractApiController {

	@SuppressWarnings("unused")
	private static final Logger logger = Logger.getLogger(JewelryApiController.class);
	
	@Autowired
	JewelryService jewelryService;
	
	@RequestMapping(method = RequestMethod.GET)
	public @ResponseBody List<Jewelry> listAll() {
		return jewelryService.loadAll();
	}
	
	@RequestMapping(value="/{jewelId}", method = RequestMethod.GET)
	public @ResponseBody Jewelry load(@PathVariable("jewelId") Long jewelId) {
		Jewelry jewel = jewelryService.getById(jewelId);
		return jewel;
	}
	
	@RequestMapping(method = RequestMethod.POST)
	public @ResponseBody Boolean save(Jewelry jewelry) {
		Long jewelId = jewelryService.save(jewelry);
		if( jewelId > 0 )
		{
			return true;
		}
		else
		{
			return false;
		}
	}
	
	@RequestMapping(value="/{jewelId}", method = RequestMethod.DELETE)
	public @ResponseBody Boolean delete(@PathVariable("jewelId") Long jewelId) {
		jewelryService.delete(jewelId);
		return true;
	}
	
}
