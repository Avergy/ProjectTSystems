package dao.implementations;

import dao.interfaces.ApartmentDao;
import entity.Apartment;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Siry on 31.05.2016.
 */
public class ApartmentDaoImpl extends AbstractGeneralDao implements ApartmentDao {
    public ApartmentDaoImpl() {
    }

    public ApartmentDaoImpl(Class clazz) {
        super(clazz);
    }

    public int findByName(String name) {
        String queryString = "SELECT a FROM Apartment a " + "WHERE a.Apartment = :name";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("name", name);
        List c = query.getResultList();
        if (!c.isEmpty())
        {
            Apartment apartment = (Apartment) c.get(0);
            return apartment.getId();
        }
        return 0;
    }
}
