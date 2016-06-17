package dao.interfaces;

import javax.persistence.Query;
import java.util.List;


public interface GenericDao<T> {

    void create(T entity);

    T merge(T entity);

    void remove(T entity);

    List<T> findAll();

    T findById(long id);

    T findOne(Query query);

}
