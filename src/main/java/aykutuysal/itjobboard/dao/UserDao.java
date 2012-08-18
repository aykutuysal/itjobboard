package aykutuysal.itjobboard.dao;

import aykutuysal.itjobboard.model.User;

public interface UserDao extends GenericDao<User, Long> {

	public User getByEmail(String email);
	
}
