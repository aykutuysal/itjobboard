package aykutuysal.itjobboard.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import aykutuysal.itjobboard.dao.UserDao;
import aykutuysal.itjobboard.model.User;
import aykutuysal.itjobboard.service.UserService;

@Service("userService")
@Transactional
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;
	
	public Long save(User user) {
		return userDao.save(user);
	}

	public User getById(Long id) {
		return userDao.getById(id);
	}
	
	public void update(User user) {
		userDao.update(user);
	}
	
	public User getMe() {
	      return (User)SecurityContextHolder.getContext().getAuthentication().getPrincipal();
	}

	public User getByEmail(String email) {
		return userDao.getByEmail(email);
	}
}
