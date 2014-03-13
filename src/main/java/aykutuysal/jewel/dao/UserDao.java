package aykutuysal.jewel.dao;

import aykutuysal.jewel.model.user.User;

public interface UserDao extends GenericDao<User, Long> {

	public User loadByEmail(String email);
	
}
