package aykutuysal.jewel.tests;

import static org.junit.Assert.*;

import org.apache.log4j.Logger;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.annotation.DirtiesContext;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.AbstractTransactionalJUnit4SpringContextTests;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import aykutuysal.jewel.model.jewelry.Jewelry;
import aykutuysal.jewel.model.jewelry.JewelryType;
import aykutuysal.jewel.service.JewelryService;
import aykutuysal.jewel.util.TestUtils;


/**
 * thanks to AbstractTransactionalJUnit4SpringContextTests
 * all created data will be cleaned after test suite is finished
 * @author aykutuysal
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring3-dispatcher-servlet.xml"})
public class JewelryServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	private static final Logger logger = Logger.getLogger(JewelryServiceTest.class);

	@Autowired
	JewelryService jewelryService;
	
	@Before
	public void setup() {
		logger.info("JewelryService Test Suit Started");
	}
	
	@Test
	@DirtiesContext
	public void saveJewelry() {

		logger.info("SaveJewelry Test Started");
		
		Jewelry jewel = TestUtils.createTestJewelry();
		Long jewelId = jewelryService.save(jewel);
		assertNotNull(jewelId);
		
		logger.info("SaveJewelry Test Finished");
	}
	
	@Test
	@DirtiesContext
	public void saveOrUpdateJewelry() {
		
		logger.info("UpdateJewelry Test Started");

		// create a jewelry
		Jewelry jewel = TestUtils.createTestJewelry();
		Long jewelId = jewelryService.save(jewel);
		assertNotNull(jewelId);

		
		Jewelry loadedJewelry = jewelryService.loadById(jewelId);
		loadedJewelry.setImagePath("testPath");
		loadedJewelry.setPrice(666L);
		loadedJewelry.setWeight(999L);
		loadedJewelry.setType(JewelryType.ATA_GOLD);
		
		jewelryService.saveOrUpdate(loadedJewelry);
		
		Jewelry loadedJewelryAfterUpdate = jewelryService.loadById(jewelId);
		assertEquals("testPath", loadedJewelryAfterUpdate.getImagePath());		
		assertEquals(666, loadedJewelryAfterUpdate.getPrice().longValue());		
		assertEquals(999, loadedJewelryAfterUpdate.getWeight().longValue());		
		assertEquals(JewelryType.ATA_GOLD, loadedJewelryAfterUpdate.getType());		
		
		logger.info("UpdateJewelry Test Finished");
	}
	
	@After
	public void tearDown() {
		logger.info("JewelryService Test Suit Finished");
	}

}
