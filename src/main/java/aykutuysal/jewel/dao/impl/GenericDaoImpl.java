package aykutuysal.jewel.dao.impl;

import java.io.Serializable;
import java.lang.reflect.ParameterizedType;
import java.util.Collection;
import java.util.List;

import org.hibernate.LockMode;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;

import aykutuysal.jewel.dao.GenericDao;

@SuppressWarnings("unchecked")
public abstract class GenericDaoImpl<T, ID extends Serializable> implements GenericDao<T, ID>
{

    protected Class<T> persistentClass;
    
    @Autowired
    protected SessionFactory sessionFactory;

    public GenericDaoImpl() {
        this.persistentClass = (Class<T>)((ParameterizedType)getClass().getGenericSuperclass()).getActualTypeArguments()[0];
    }

    public T getById(ID id) {
        return (T)sessionFactory.getCurrentSession().get(persistentClass, id);
    }

    @SuppressWarnings("deprecation")
	public T getById(ID id, boolean lock) {
        if(lock) {
            return (T)sessionFactory.getCurrentSession().get(persistentClass, id, LockMode.UPGRADE);
        }
        else
            return getById(id);
    }

    public T loadById(ID id) {
        return (T)sessionFactory.getCurrentSession().load(persistentClass, id);
    }

    public ID save(T entity) {
        return (ID)sessionFactory.getCurrentSession().save(entity);
    }

    public void update(T entity) {
    	sessionFactory.getCurrentSession().update(entity);
    }

    public void saveOrUpdate(T entity) {
    	sessionFactory.getCurrentSession().saveOrUpdate(entity);
    }

    public void saveOrUpdateAll(Collection<T> entityCollection) {
    	sessionFactory.getCurrentSession().saveOrUpdate(entityCollection);
    }

    public void delete(T entity) {
    	sessionFactory.getCurrentSession().delete(entity);
    }

    public void deleteById(ID id) {
    	sessionFactory.getCurrentSession().delete(loadById(id));
    }

    public void deleteAll(Collection<T> entityCollection) {
    	sessionFactory.getCurrentSession().delete(entityCollection);
    }

    public List<T> loadAll() {
        return sessionFactory.getCurrentSession().createCriteria(persistentClass).list();

    }

    public List<T> loadAll(int start, int end) {
        return sessionFactory.getCurrentSession().createCriteria(persistentClass).list().subList(start, end);
    }

    public T merge(T entity) {
        return (T)sessionFactory.getCurrentSession().merge(entity);
    }

    public void refresh(T entity) {
    	sessionFactory.getCurrentSession().refresh(entity);
    }

    public void evict(T entity) {
    	sessionFactory.getCurrentSession().evict(entity);
    }
    
    public void flush() {
    	sessionFactory.getCurrentSession().flush();
    }
    
}

