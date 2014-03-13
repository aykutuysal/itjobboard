package aykutuysal.jewel.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import aykutuysal.jewel.dao.UserDao;
import aykutuysal.jewel.model.user.User;



@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

	@SuppressWarnings("unchecked")
	public User loadByEmail(String email) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(persistentClass);
		criteria.add(Restrictions.eq("email", email));
		return (User)DataAccessUtils.singleResult(criteria.list());	
	}

}
