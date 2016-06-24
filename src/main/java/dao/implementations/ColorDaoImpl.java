package dao.implementations;

import Util.EntityManagerUtil;
import dao.interfaces.ColorDao;
import entity.Color;

import javax.persistence.EntityManager;
import javax.persistence.Query;


public class ColorDaoImpl extends AbstractGenericDao implements ColorDao {

    public ColorDaoImpl() {
        super();
        setEntityClass(Color.class);
    }

    public Color findByColor(String color) {
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Query query = entityManager.createQuery("Select c FROM Color c WHERE c.color = :color");
        query.setParameter("color", color);
        Color color1 = (Color) findOne(query);
        entityManager.close();
        return color1;
    }
}
