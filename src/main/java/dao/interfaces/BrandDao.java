package dao.interfaces;

import entity.Brand;


public interface BrandDao extends GenericDao {

    Brand findByBrand(String brandName);
}
