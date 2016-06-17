package dao.implementations;


import dao.interfaces.GenericDao;

import javax.persistence.*;
import java.util.List;


public abstract class AbstractGenericDao<T> implements GenericDao<T> {

    private Class entityClass;
    private static EntityManagerFactory entityManagerFactory;


    protected EntityManager entityManager = getEntityManagerFactory().createEntityManager();

    public AbstractGenericDao(){
    }

    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }

    public static EntityManagerFactory getEntityManagerFactory() {
        if (entityManagerFactory == null)
            entityManagerFactory = Persistence.createEntityManagerFactory("ProjectJS");
        return entityManagerFactory;
    }

    public void create(T entity) {
        entityManager.getTransaction().begin();
        entityManager.merge(entity);
        entityManager.getTransaction().commit();
    }

    public T merge(T entity) {
        entityManager.getTransaction().begin();
        T newT = entityManager.merge(entity);
        entityManager.getTransaction().commit();
        return newT;
    }

    public void remove(T entity) {
        entityManager.getTransaction().begin();
        entityManager.remove(entity);
        entityManager.getTransaction().commit();
    }


    public List<T> findAll() {
        List list = null;
        entityManager.getTransaction().begin();
        Query query = entityManager.createQuery("from " + entityClass.getName());
        list = query.getResultList();
        entityManager.getTransaction().commit();
        return list;
    }

    public T findById(long id) {
        entityManager.getTransaction().begin();
        T newT = (T) entityManager.find(entityClass, id);
        entityManager.getTransaction().commit();
        return newT;
    }

    public T findOne(Query query) {
        T t;
        entityManager.getTransaction().begin();
        t = (T) query.getSingleResult();
        entityManager.getTransaction().commit();
        return t;
    }
}
