package services.simple.implementations;

import dao.interfaces.ApartmentDao;
import entity.Apartment;
import services.simple.interfaces.ApartmentService;

/**
 * Created by Siry on 01.06.2016.
 */
public class ApartmentServiceImpl implements ApartmentService {

    private ApartmentDao apartmentDao;

    public ApartmentServiceImpl() {
    }

    public ApartmentDao getApartmentDao() {
        return apartmentDao;
    }

    public void setApartmentDao(ApartmentDao apartmentDao) {
        this.apartmentDao = apartmentDao;
    }

    public Apartment add(Apartment apartment) {
        int id = apartmentDao.findByName(apartment.getApartment());
        if (id == 0)
            return (Apartment) apartmentDao.create(apartment);
        apartment.setId(id);
        return apartment;
    }

    public Apartment read(int id) {
        return (Apartment) apartmentDao.findById(id);
    }

    public void update(Apartment apartment) {
        apartmentDao.merge(apartment);
    }

    public void delete(int id) {
        Apartment apartment = (Apartment) apartmentDao.findById(id);
        if (apartment != null)
            apartmentDao.remove(apartment);
    }

    public int ApartmentInDB(String nameApartment) {
        return apartmentDao.findByName(nameApartment);
    }

}
