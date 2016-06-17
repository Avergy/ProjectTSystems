package services.interfaces;

import entity.Brand;
import entity.Phone;

import java.util.List;


public interface PhoneService {

    void addNewPhone(Phone phone);

    Phone loadPhone(long id);

    void updatePhone(Phone phone);

    void deletePhone(long id);

    List<Phone> loadAllPhones();

    List<Phone> loadPhonesByBrand(Brand brand);
}
