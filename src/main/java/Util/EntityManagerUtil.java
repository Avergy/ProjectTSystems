package Util;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

public class EntityManagerUtil {

    private static EntityManagerFactory entityManagerFactory;

    public static EntityManagerFactory getEntityManagerFactory(){
        if (entityManagerFactory == null)
            entityManagerFactory = Persistence.createEntityManagerFactory("ProjectJS");
        return entityManagerFactory;
    }

    public static EntityManager beginTransaction() {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        entityManager.getTransaction().begin();
        return entityManager;
    }

    public static void commitTransaction(EntityManager entityManager) {
        entityManager.getTransaction().commit();
    }

    public static void rollbackTransaction(EntityManager entityManager) {
        entityManager.getTransaction().rollback();
    }

    public static EntityManager getEntityManager() {
        return getEntityManagerFactory().createEntityManager();
    }
}
