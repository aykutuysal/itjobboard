package aykutuysal.jewel.service.impl;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aykutuysal.jewel.dao.UserDao;
import aykutuysal.jewel.model.user.User;
import aykutuysal.jewel.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	private static final Logger logger = Logger.getLogger(UserServiceImpl.class);

	@Autowired
	private UserDao userDao;

	public Long save(User user) {
		return userDao.save(user);
	}
	
	public User getById(Long userId) {
		return userDao.getById(userId);
	}
	
	public User loadById(Long userId) {
		return userDao.loadById(userId);
	}
	
	public void saveOrUpdate(User user) {
		userDao.saveOrUpdate(user);
	}
	
	public User getMe() {
	      return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public User loadByEmail(String email) {
		User user = userDao.loadByEmail(email);
		logger.debug("User loaded by email(" + email + "): " + user);
		return user;
	}

	public boolean registerUser(User user) {

		// check user existence
		User u = loadByEmail(user.getEmail());
		if( u == null ) {
			
			// save user to db
			save(user);
			return true;
		} else {			
			return false;
		}
	}
}
