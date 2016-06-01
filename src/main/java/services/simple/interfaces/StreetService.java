package services.simple.interfaces;

import entity.Street;

/**
 * Created by Siry on 01.06.2016.
 */
public interface StreetService {

    Street add(Street street);

    Street read(int id);

    void update(Street street);

    void delete(int id);

    int StreetInDB(String nameStreet);
}
