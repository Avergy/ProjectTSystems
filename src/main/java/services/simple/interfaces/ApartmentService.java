package services.simple.interfaces;

import entity.Apartment;

/**
 * Created by Siry on 01.06.2016.
 */
public interface ApartmentService {
    Apartment add(Apartment apartment);

    Apartment read(int id);

    void update(Apartment apartment);

    void delete(int id);

    int ApartmentInDB(String nameApartment);
}
