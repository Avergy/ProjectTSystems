package services.simple.implementations;

import dao.interfaces.CityDao;
import entity.City;
import services.simple.interfaces.CityService;

/**
 * Created by Siry on 01.06.2016.
 */
public class CityServiceImpl implements CityService {

    private CityDao cityDao;

    public CityServiceImpl() {
    }

    public CityDao getCityDao() {
        return cityDao;
    }

    public void setCityDao(CityDao cityDao) {
        this.cityDao = cityDao;
    }

    public City add(City city) {
        int id = cityDao.findByName(city.getCity());
        if (id == 0)
            return (City) cityDao.create(city);
        city.setId(id);
        return city;
    }

    public City read(int id) {
        return (City) cityDao.findById(id);
    }

    public void update(City city) {
        cityDao.merge(city);
    }

    public void delete(int id) {
        City city = (City) cityDao.findById(id);
        if (city != null)
            cityDao.remove(city);

    }

    public int CityInDB(String nameCity) {
        return cityDao.findByName(nameCity);
    }
}
