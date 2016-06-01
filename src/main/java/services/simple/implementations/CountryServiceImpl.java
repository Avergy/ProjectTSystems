package services.simple.implementations;

import dao.interfaces.CountryDao;
import entity.Country;
import services.simple.interfaces.CountryService;

/**
 * Created by Siry on 01.06.2016.
 */
public class CountryServiceImpl implements CountryService {

    private CountryDao countryDao;

    public CountryServiceImpl() {
    }

    public CountryDao getCountryDao() {
        return countryDao;
    }

    public void setCountryDao(CountryDao countryDao) {
        this.countryDao = countryDao;
    }

    public Country add(Country country) {
        int id = countryDao.findByName(country.getCountryName());
        if (id == 0)
         return (Country) countryDao.create(country);
        country.setId(id);
        return country;
    }

    public Country read(int id) {
        return (Country) countryDao.findById(id);
    }

    public void update(Country country) {
        countryDao.merge(country);
    }

    public void delete(int id) {
        Country country = (Country) countryDao.findById(id);
        if (country != null)
            countryDao.remove(country);
    }

    public int CountryInDB(String nameCountry) {
        return countryDao.findByName(nameCountry);
    }
}
