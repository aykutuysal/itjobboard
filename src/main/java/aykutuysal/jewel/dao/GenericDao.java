package aykutuysal.jewel.dao;

import java.io.Serializable;
import java.util.Collection;
import java.util.List;

public interface GenericDao<T, ID extends Serializable> {
    T getById(ID id, boolean lock);
    T getById(ID id);
    T loadById(ID id);
    List<T> loadAll();
    List<T> loadAll(int start, int end);
    ID save(T entity);
    void update(T entity);
    void saveOrUpdate(T entity);
    void saveOrUpdateAll(Collection<T> entityCollection);
    void delete(T entity);
    void deleteById(ID id);
    void deleteAll(Collection<T> entityCollection);
    T merge(T entity);
    void refresh(T entity);
    void evict(T entity);
    void flush();
}
