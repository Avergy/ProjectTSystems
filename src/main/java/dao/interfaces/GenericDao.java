package dao.interfaces;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public interface GenericDao<T> {

    void create(T entity, EntityManager em);

    void merge(T entity, EntityManager em);

    void remove(T entity, EntityManager em);

    List<T> findAll();

    T findById(long id);

    T findOne(Query query);

    List<T> findMany(Query query);
}
