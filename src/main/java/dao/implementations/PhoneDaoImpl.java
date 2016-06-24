package dao.implementations;

import Util.EntityManagerUtil;
import dao.interfaces.PhoneDao;
import entity.Brand;
import entity.Color;
import entity.Phone;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class PhoneDaoImpl extends AbstractGenericDao implements PhoneDao{

    final static Logger logger = Logger.getLogger(PhoneDaoImpl.class.getName());

    public PhoneDaoImpl() {
        super();
        setEntityClass(Phone.class);
    }

    @Override
    public List<Phone> findByBrand(Brand brand) {
        logger.info("Find phones in the DB by brand...");
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Query query = entityManager.createQuery("Select p FROM Phone p WHERE p.brand = :brand");
        query.setParameter("brand", brand);
        List<Phone> phones = findMany(query);
        entityManager.close();
        logger.info("Phones by brand has been found.");
        return phones;
    }

    @Override
    public List<Phone> findByName(String phoneName) {
        logger.info("Find phones in the DB by name...");
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Query query = entityManager.createQuery("Select p FROM Phone p WHERE p.name = :phoneName");
        query.setParameter("phoneName", phoneName);
        List<Phone> phones = findMany(query);
        entityManager.close();
        logger.info("Phones by name has been found.");
        return phones;
    }

    @Override
    public List<Phone> findByColor(Color color) {
        logger.info("Find phones in the DB by color...");
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Query query = entityManager.createQuery("Select p FROM Phone p WHERE p.color = :color");
        query.setParameter("color", color);
        List<Phone> phones = findMany(query);
        entityManager.close();
        logger.info("Phones by color has been found.");
        return phones;
    }

    @Override
    public boolean setPhoneQuantity(long id, int quantity, EntityManager entityManager) {
        logger.info("Change phone quantity after create new order...");
        Phone phone = (Phone) findById(id);
        int quantityStock = phone.getQuantityStock();
        if (quantityStock > quantity) {
            phone.setQuantityStock(quantityStock - quantity);
            merge(phone, entityManager);
            logger.info("Phone quantity has been changed.");
            return true;
        } else
            logger.info("Phone quantity has not been changed.");
            return false;
    }
}