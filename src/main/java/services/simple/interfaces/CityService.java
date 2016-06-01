package services.simple.interfaces;

import entity.City;

/**
 * Created by Siry on 01.06.2016.
 */
public interface CityService {

    City add(City city);

    City read(int id);

    void update(City city);

    void delete(int id);

    int CityInDB(String nameCity);
}
