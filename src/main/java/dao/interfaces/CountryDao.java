package dao.interfaces;

/**
 * Created by Siry on 01.06.2016.
 */
public interface CountryDao extends GeneralDao {

    int findByName(String name);
}
