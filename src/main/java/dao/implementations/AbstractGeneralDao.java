package dao.implementations;


import dao.interfaces.GeneralDao;
import entity.Country;

import javax.persistence.*;
import java.lang.reflect.ParameterizedType;
import java.util.List;
import java.util.Queue;

/**
 * Created by Siry on 31.05.2016.
 */
public abstract class AbstractGeneralDao<T> implements GeneralDao<T> {

    protected Class entityClass;

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectJS");
    protected EntityManager entityManager = emf.createEntityManager();

    public AbstractGeneralDao(){
    }

    public AbstractGeneralDao(Class clazz){
        entityClass = clazz;
    }

    public T create(T entity) {
        entityManager.getTransaction().begin();
        T newT = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return newT;
    }

    public void merge(T entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public void remove(T entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }


    public List<T> findAll() {
        List list = null;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from" + entityClass);
        entityManager.getTransaction().commit();
        list = query.getResultList();
        return list;
    }

    public T findById(int id) {
        entityManager.getTransaction().begin();
        T newT = (T) entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        return newT;
    }

}
