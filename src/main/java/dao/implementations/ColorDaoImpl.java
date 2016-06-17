package dao.implementations;

import dao.interfaces.ColorDao;
import entity.Color;

import javax.persistence.Query;
import java.util.List;


public class ColorDaoImpl extends AbstractGenericDao implements ColorDao {

    public ColorDaoImpl() {
        super();
        setEntityClass(Color.class);
    }

    public Color findByColor(String color) {
        Query query = entityManager.createQuery("Select c FROM Color c WHERE c.color = :color");
        query.setParameter("color", color);
        List list = query.getResultList();
        if (list.isEmpty())
            return null;
        return (Color) list.get(0);
    }
}
