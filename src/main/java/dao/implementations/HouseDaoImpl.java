package dao.implementations;

import dao.interfaces.HouseDao;
import entity.House;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Siry on 01.06.2016.
 */
public class HouseDaoImpl extends AbstractGeneralDao implements HouseDao {

    public HouseDaoImpl() {
    }

    public HouseDaoImpl(Class clazz) {
        super(clazz);
    }

    public int findByName(String name) {
        String queryString = "SELECT a FROM House a " + "WHERE a.house = :name";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("name", name);
        List c = query.getResultList();
        if (!c.isEmpty())
        {
            House house = (House) c.get(0);
            return house.getId();
        }
        return 0;
    }
}
