package dao.implementations;

import dao.interfaces.BrandDao;
import entity.Brand;

import javax.persistence.Query;
import java.util.List;


public class BrandDaoImpl extends AbstractGenericDao implements BrandDao {

    public BrandDaoImpl() {
        super();
        setEntityClass(Brand.class);
    }

    public Brand findByBrand(String brandName) {
        Query query = entityManager.createQuery("Select b FROM Brand b WHERE b.brand = :brandName");
        query.setParameter("brandName", brandName);
        Brand brand = (Brand) query.getSingleResult();
        return brand;
    }


}
