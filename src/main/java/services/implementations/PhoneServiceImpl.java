package services.implementations;

import Util.DAOsUtil;
import Util.EntityManagerUtil;
import dao.interfaces.PhoneDao;
import entity.Brand;
import entity.Phone;
import exceptions.DuplicateDBException;
import services.interfaces.PhoneService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class PhoneServiceImpl implements PhoneService {

    private PhoneDao phoneDao = DAOsUtil.getPhoneDao();

    public void addNewPhone(Phone phone) throws DuplicateDBException {
        EntityManager entityManager = null;
        try{
            entityManager = EntityManagerUtil.beginTransaction();
            phoneDao.create(phone, entityManager);
            EntityManagerUtil.commitTransaction(entityManager);
        } catch (PersistenceException e)
        {
            e.printStackTrace();
            EntityManagerUtil.rollbackTransaction(entityManager);
            throw new DuplicateDBException();
        }
    }

    public Phone loadPhone(long id) {
        return (Phone) phoneDao.findById(id);
    }

    public void updatePhone(Phone phone) throws DuplicateDBException {
        EntityManager entityManager = null;
        try{
            entityManager = EntityManagerUtil.beginTransaction();
            phoneDao.merge(phone, entityManager);
            EntityManagerUtil.commitTransaction(entityManager);
        } catch (PersistenceException e)
        {
            e.printStackTrace();
            EntityManagerUtil.rollbackTransaction(entityManager);
            throw new DuplicateDBException();
        }
    }

    public void deletePhone(Phone phone) {
        EntityManager entityManager = null;
        try{
            entityManager = EntityManagerUtil.beginTransaction();
            phoneDao.remove(phone, entityManager);
            EntityManagerUtil.commitTransaction(entityManager);
        } catch (PersistenceException e)
        {
            e.printStackTrace();
            EntityManagerUtil.rollbackTransaction(entityManager);
        }
    }

    public List<Phone> loadAllPhones() {
        return phoneDao.findAll();
    }

    @Override
    public List<Phone> loadPhonesByBrand(Brand brand) {
        return phoneDao.findByBrand(brand);
    }

    @Override
    public Phone findPhoneById(long id) {
        return (Phone) phoneDao.findById(id);
    }

}
