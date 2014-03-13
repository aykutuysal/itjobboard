package aykutuysal.jewel.util;

import java.util.Date;

import aykutuysal.jewel.model.jewelry.Jewelry;
import aykutuysal.jewel.model.jewelry.JewelryType;
import aykutuysal.jewel.model.user.User;

public class TestUtils {

	public static User createTestUser() {
		User user = new User();
		user.setEmail("aykutuysal-test@gmail.com");
		user.setFirstName("AykutTest");
		user.setLastName("UysalTest");
		user.setPassword("1q2w3e");
		user.setPhone("05054795629");
		user.setRegistrationDate(new Date());
		return user;
	}
	
	public static Jewelry createTestJewelry() {
		Jewelry jewel = new Jewelry();
		jewel.setImagePath("http://www.altinfiyatlari24.com/files/image/CumhuriyetAltini-2.jpg");
		jewel.setPrice(200L);
		jewel.setType(JewelryType.REPUBLIC_GOLD);
		jewel.setWeight(10L);
		return jewel;
	}
}
