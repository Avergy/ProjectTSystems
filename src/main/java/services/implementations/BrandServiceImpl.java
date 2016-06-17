package services.implementations;

import dao.implementations.BrandDaoImpl;
import dao.interfaces.BrandDao;
import entity.Brand;
import services.interfaces.BrandService;

import javax.persistence.PersistenceException;
import java.util.List;


public class BrandServiceImpl implements BrandService {

    private BrandDao brandDao = new BrandDaoImpl();

    public BrandDao getBrandDao() {
        return brandDao;
    }

    public void setBrandDao(BrandDao brandDao) {
        this.brandDao = brandDao;
    }

    public void addNewBrand(Brand brand) {
        brandDao.create(brand);
    }

    @Override
    public Brand findByBrandName(String brandName) {
        return brandDao.findByBrand(brandName);
    }

    public List<Brand> loadAllBrands() {
        return brandDao.findAll();
    }
}