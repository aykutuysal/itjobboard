package aykutuysal.itjobboard.dao.impl;

import org.hibernate.Criteria;
import org.hibernate.criterion.Restrictions;
import org.springframework.dao.support.DataAccessUtils;
import org.springframework.stereotype.Repository;

import aykutuysal.itjobboard.dao.UserDao;
import aykutuysal.itjobboard.model.User;

@Repository
public class UserDaoImpl extends GenericDaoImpl<User, Long> implements UserDao {

	@SuppressWarnings("unchecked")
	public User getByEmail(String email) {
		Criteria criteria = this.sessionFactory.getCurrentSession().createCriteria(persistentClass);
		criteria.add(Restrictions.eq("email", email));
		return (User)DataAccessUtils.singleResult(criteria.list());	
	}

}
