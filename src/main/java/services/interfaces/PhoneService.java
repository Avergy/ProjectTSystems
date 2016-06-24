package services.interfaces;

import entity.Brand;
import entity.Color;
import entity.Phone;
import exceptions.DuplicateDBException;

import java.util.List;


public interface PhoneService {

    void addNewPhone(Phone phone) throws DuplicateDBException;

    Phone loadPhone(long id);

    void updatePhone(Phone phone) throws DuplicateDBException;

    List<Phone> loadAllPhones();

    List<Phone> loadPhonesByBrand(Brand brand);

    Phone findPhoneById(long id);

}
