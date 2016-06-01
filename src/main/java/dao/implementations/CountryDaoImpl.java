package dao.implementations;



import com.sun.deploy.util.StringUtils;
import dao.interfaces.CountryDao;
import dao.interfaces.GeneralDao;
import entity.Country;

import javax.persistence.Query;
import java.util.List;

/**
 * Created by Siry on 01.06.2016.
 */
public class CountryDaoImpl extends AbstractGeneralDao implements CountryDao {
    public CountryDaoImpl() {
    }

    public CountryDaoImpl(Class clazz) {
        super(clazz);
    }

    public int findByName(String name) {
        String queryString = "SELECT a FROM Country a " + "WHERE a.CountryName = :name";
        Query query = entityManager.createQuery(queryString);
        query.setParameter("name", name);
        List c = query.getResultList();
        if (!c.isEmpty())
        {
            Country country = (Country) c.get(0);
            return country.getId();
        }
        return 0;
    }
}
