package services.implementations;

import dao.implementations.PhoneDaoImpl;
import dao.interfaces.PhoneDao;
import entity.Brand;
import entity.Phone;
import services.interfaces.PhoneService;

import java.util.List;

public class PhoneServiceImpl implements PhoneService {

    private PhoneDao phoneDao = new PhoneDaoImpl();

    public PhoneDao getPhoneDao() {
        return phoneDao;
    }

    public void setPhoneDao(PhoneDao phoneDao) {
        this.phoneDao = phoneDao;
    }

    public void addNewPhone(Phone phone) {
        phoneDao.create(phone);
    }

    public Phone loadPhone(long id) {
        return (Phone) phoneDao.findById(id);
    }

    public void updatePhone(Phone phone) {
        phoneDao.merge(phone);
    }

    public void deletePhone(long id) {
        Phone phone = (Phone) phoneDao.findById(id);
        phoneDao.remove(phone);
    }

    public List<Phone> loadAllPhones() {
        return phoneDao.findAll();
    }

    @Override
    public List<Phone> loadPhonesByBrand(Brand brand) {
        return phoneDao.findByBrand(brand);
    }
}
