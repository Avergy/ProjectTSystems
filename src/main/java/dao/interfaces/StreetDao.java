package dao.interfaces;

/**
 * Created by Siry on 01.06.2016.
 */
public interface StreetDao extends GeneralDao{

    int findByName(String name);
}
