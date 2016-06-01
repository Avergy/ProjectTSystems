package services.simple.interfaces;

import entity.Country;

/**
 * Created by Siry on 01.06.2016.
 */
public interface CountryService{

    Country add(Country country);

    Country read(int id);

    void update(Country country);

    void delete(int id);

    int CountryInDB(String nameCountry);

}
