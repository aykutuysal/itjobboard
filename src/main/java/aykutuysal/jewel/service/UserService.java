package aykutuysal.jewel.service;

import aykutuysal.jewel.model.user.User;

public interface UserService {
	public Long save(User user);
	public User getById(Long id);
	public User loadById(Long id);
	public void saveOrUpdate(User user);
	public User getMe();
	public User loadByEmail(String email);
	public boolean registerUser(User user);
}
