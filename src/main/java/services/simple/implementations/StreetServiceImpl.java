package services.simple.implementations;

import dao.interfaces.StreetDao;
import entity.Street;
import services.simple.interfaces.StreetService;

/**
 * Created by Siry on 01.06.2016.
 */
public class StreetServiceImpl implements StreetService {

    private StreetDao streetDao;

    public StreetServiceImpl() {
    }

    public StreetDao getStreetDao() {
        return streetDao;
    }

    public void setStreetDao(StreetDao streetDao) {
        this.streetDao = streetDao;
    }

    public Street add(Street street) {
        int id = streetDao.findByName(street.getStreet());
        if (id == 0)
            return (Street) streetDao.create(street);
        street.setId(id);
        return street;
    }

    public Street read(int id) {
        return (Street) streetDao.findById(id);
    }

    public void update(Street street) {
        streetDao.merge(street);
    }

    public void delete(int id) {
        Street street = (Street) streetDao.findById(id);
        if (street != null)
            streetDao.remove(street);
    }

    public int StreetInDB(String nameStreet) {
        return streetDao.findByName(nameStreet);
    }

}
