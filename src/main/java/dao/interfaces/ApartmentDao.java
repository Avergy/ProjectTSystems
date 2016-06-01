package dao.interfaces;

/**
 * Created by Siry on 31.05.2016.
 */
public interface ApartmentDao extends GeneralDao {

    int findByName(String name);
}
