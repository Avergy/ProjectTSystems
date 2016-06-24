package dao.implementations;


import Util.EntityManagerUtil;
import dao.interfaces.GenericDao;
import org.apache.log4j.Logger;

import javax.persistence.*;
import java.util.List;


public abstract class AbstractGenericDao<T> implements GenericDao<T> {

    private Class entityClass;
    final static Logger logger = Logger.getLogger(AbstractGenericDao.class.getName());

    public AbstractGenericDao(){
    }

    public void setEntityClass(Class entityClass) {
        this.entityClass = entityClass;
    }

    public void create(T entity, EntityManager entityManager) {
        logger.info("Saving entity...");
        entityManager.persist(entity);
        logger.info("Entity has been saved.");
    }

    public void merge(T entity, EntityManager entityManager) {
        logger.info("Merging entity...");
        entityManager.merge(entity);
        logger.info("Entity has been merged.");
    }

    public void remove(T entity, EntityManager entityManager) {
        logger.info("Deleting entity...");
        entityManager.remove(entityManager.contains(entity) ? entity :entityManager.merge(entity));
        logger.info("Entity has been deleted.");
    }


    public List<T> findAll() {
        logger.info("Searching all of entities...");
        List list = null;
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Query query = entityManager.createQuery("from " + entityClass.getName());
        list = query.getResultList();
        entityManager.close();
        logger.info("Returning List of entities.");
        return list;
    }

    public T findById(long id) {
        logger.info("Searching one of entities by id...");
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        T newT = (T) entityManager.find(entityClass, id);
        entityManager.close();
        logger.info("Returning found entity.");
        return newT;
    }

    public T findOne(Query query) {
        logger.info("Searching one of entities...");
        T t;
        t = (T) query.getSingleResult();
        logger.info("Returning found entity.");
        return t;
    }

    @Override
    public List<T> findMany(Query query) {
        logger.info("Searching some entities...");
        List<T> list;
        list = (List<T>) query.getResultList();
        logger.info("Returning List of entities.");
        return list;
    }
}
