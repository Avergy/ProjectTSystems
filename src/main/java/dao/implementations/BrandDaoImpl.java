package dao.implementations;

import Util.EntityManagerUtil;
import dao.interfaces.BrandDao;
import entity.Brand;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class BrandDaoImpl extends AbstractGenericDao implements BrandDao {

    public BrandDaoImpl() {
        super();
        setEntityClass(Brand.class);
    }

    public Brand findByBrand(String brandName) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Query query = entityManager.createQuery("Select b FROM Brand b WHERE b.brand = :brandName");
        query.setParameter("brandName", brandName);
        Brand brand = (Brand) findOne(query);
        entityManager.close();
        return brand;
    }


}
