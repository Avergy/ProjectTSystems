package dao.interfaces;

import java.util.List;

/**
 * Created by Siry on 31.05.2016.
 */
public interface GeneralDao<T> {

    T create(T entity);

    void merge(T entity);

    void remove(T entity);

    List<T> findAll();

    T findById(long id);

}
