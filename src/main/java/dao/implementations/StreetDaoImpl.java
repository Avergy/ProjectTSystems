package dao.implementations;

import dao.interfaces.GeneralDao;
import dao.interfaces.StreetDao;
import entity.Street;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Siry on 01.06.2016.
 */
public class StreetDaoImpl extends AbstractGeneralDao implements StreetDao{

    public StreetDaoImpl() {
    }

    public StreetDaoImpl(Class clazz) {
        super(clazz);
    }

    public int findByName(String name) {
        String queryString = "SELECT a FROM Street a " + "WHERE a.street = :name";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("name", name);
        List c = query.getResultList();
        if (!c.isEmpty())
        {
            Street street = (Street) c.get(0);
            return street.getId();
        }
        return 0;
    }
}
