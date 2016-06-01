package services.simple.implementations;

import dao.interfaces.HouseDao;
import entity.House;
import services.simple.interfaces.HouseService;

/**
 * Created by Siry on 01.06.2016.
 */
public class HouseServiceImpl implements HouseService {

    private HouseDao houseDao;

    public HouseServiceImpl() {
    }

    public HouseDao getHouseDao() {
        return houseDao;
    }

    public void setHouseDao(HouseDao houseDao) {
        this.houseDao = houseDao;
    }

    public House add(House house) {
        int id = houseDao.findByName(house.getHouse());
        if (id == 0)
            return (House) houseDao.create(house);
        house.setId(id);
        return house;
    }

    public House read(int id) {
        return (House) houseDao.findById(id);
    }

    public void update(House house) {
        houseDao.merge(house);
    }

    public void delete(int id) {
        House house = (House) houseDao.findById(id);
        if (house != null)
            houseDao.remove(house);
    }

    public int HouseInDB(String nameHouse) {
        return houseDao.findByName(nameHouse);
    }


}
