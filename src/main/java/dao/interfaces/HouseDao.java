package dao.interfaces;

/**
 * Created by Siry on 01.06.2016.
 */
public interface HouseDao extends GeneralDao {

    int findByName(String name);
}
