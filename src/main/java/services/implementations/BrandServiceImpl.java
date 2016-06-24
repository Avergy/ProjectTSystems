package services.implementations;

import Util.DAOsUtil;
import Util.EntityManagerUtil;
import dao.interfaces.BrandDao;
import entity.Brand;
import exceptions.DuplicateDBException;
import services.interfaces.BrandService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;


public class BrandServiceImpl implements BrandService {

    private BrandDao brandDao = DAOsUtil.getBrandDao();

    public void addNewBrand(Brand brand) throws DuplicateDBException {
        EntityManager entityManager = null;
        try{
            entityManager = EntityManagerUtil.beginTransaction();
            brandDao.create(brand, entityManager);
            EntityManagerUtil.commitTransaction(entityManager);
        }catch (PersistenceException e) {
            e.printStackTrace();
            EntityManagerUtil.rollbackTransaction(entityManager);
            throw new DuplicateDBException();
        }
    }

    @Override
    public Brand findByBrandName(String brandName) {
        return brandDao.findByBrand(brandName);
    }

    public List<Brand> loadAllBrands() {
        return brandDao.findAll();
    }

    @Override
    public void updateBrand(Brand brand) {

        EntityManager entityManager = null;
        try{
            entityManager = EntityManagerUtil.beginTransaction();
            brandDao.merge(brand, entityManager);
            EntityManagerUtil.commitTransaction(entityManager);
        }catch (PersistenceException e)
        {
            e.printStackTrace();
            EntityManagerUtil.rollbackTransaction(entityManager);
        }
    }

    @Override
    public void deleteBrand(Brand brand) {
        EntityManager entityManager = null;
        try {
            entityManager = EntityManagerUtil.beginTransaction();
            brandDao.remove(brand, entityManager);
            EntityManagerUtil.commitTransaction(entityManager);
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            EntityManagerUtil.rollbackTransaction(entityManager);
        }
    }
}