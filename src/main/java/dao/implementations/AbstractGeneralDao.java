package dao.implementations;


import dao.interfaces.GeneralDao;

import javax.persistence.*;
import java.util.List;

/**
 * Created by Siry on 31.05.2016.
 */
public abstract class AbstractGeneralDao<T> implements GeneralDao<T> {

    protected Class entityClass;

    protected EntityManagerFactory emf = Persistence.createEntityManagerFactory("ProjectJS");
    protected EntityManager entityManager = emf.createEntityManager();

    public AbstractGeneralDao(){
    }


    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
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

    public T findById(long id) {
        entityManager.getTransaction().begin();
        T newT = (T) entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        return newT;
    }

}
