package dao.implementations;

import dao.interfaces.CityDao;
import entity.City;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Siry on 01.06.2016.
 */
public class CityDaoImpl extends AbstractGeneralDao implements CityDao {

    public CityDaoImpl() {
    }

    public CityDaoImpl(Class clazz) {
        super(clazz);
    }

    public int findByName(String name) {
        String queryString = "SELECT a FROM City a " + "WHERE a.city = :name";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("name", name);
        List c = query.getResultList();
        if (!c.isEmpty())
        {
            City city = (City) c.get(0);
            return city.getId();
        }
        return 0;
    }
}
