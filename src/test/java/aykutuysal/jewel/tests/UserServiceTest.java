package aykutuysal.jewel.tests;

import static org.junit.Assert.*;

import java.util.Date;

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

import com.mchange.util.AssertException;

import aykutuysal.jewel.model.user.User;
import aykutuysal.jewel.service.UserService;
import aykutuysal.jewel.util.TestUtils;


/**
 * thanks to AbstractTransactionalJUnit4SpringContextTests
 * all created data will be cleaned after test suite is finished
 * @author aykutuysal
 */

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations={"file:src/main/webapp/WEB-INF/spring3-dispatcher-servlet.xml"})
public class UserServiceTest extends AbstractTransactionalJUnit4SpringContextTests {

	private static final Logger logger = Logger.getLogger(UserServiceTest.class);

	@Autowired
	UserService userService;
	
	@Before
	public void setup() {
		logger.info("Starting UserService Test Suit");
	}
	
	@Test
	@DirtiesContext
	public void saveUser() {

		logger.info("SaveUser Test Started");
		
		User user = TestUtils.createTestUser();
		Long userId = userService.save(user);
		assertNotNull(userId);
		
		logger.info("SaveUser Test Finished");
	}
	
	@Test
	@DirtiesContext
	public void saveOrUpdateUser() {
		
		logger.info("UpdateUser Test Started");

		// create a user
		User user = TestUtils.createTestUser();
		Long userId = userService.save(user);
		assertNotNull(userId);

		User loadedUser = userService.loadById(userId);
		loadedUser.setFirstName("UpdateTestFirstName");
		loadedUser.setLastName("UpdateTestLastName");
		userService.saveOrUpdate(loadedUser);
		
		User loadedUserAfterUpdate = userService.loadById(userId);
		assertEquals("UpdateTestFirstName", loadedUserAfterUpdate.getFirstName());		
		assertEquals("UpdateTestLastName", loadedUserAfterUpdate.getLastName());
		
		logger.info("UpdateUser Test Finished");
	}
	
	@After
	public void tearDown() {
		logger.info("UserService Test Suit Finished");
	}

}
