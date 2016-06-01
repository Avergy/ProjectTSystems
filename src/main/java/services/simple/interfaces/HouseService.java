package services.simple.interfaces;

import entity.House;

/**
 * Created by Siry on 01.06.2016.
 */
public interface HouseService {

    House add(House house);

    House read(int id);

    void update(House house);

    void delete(int id);

    int HouseInDB(String nameHouse);
}
