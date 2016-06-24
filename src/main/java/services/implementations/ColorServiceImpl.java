package services.implementations;

import Util.DAOsUtil;
import Util.EntityManagerUtil;
import dao.interfaces.ColorDao;
import entity.Color;
import exceptions.DuplicateDBException;
import services.interfaces.ColorService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;


public class ColorServiceImpl implements ColorService {

    private ColorDao colorDao = DAOsUtil.getColorDao();

    public void addNewColor(Color color) throws DuplicateDBException {
        EntityManager entityManager = null;
        try{
            entityManager = EntityManagerUtil.beginTransaction();
            colorDao.create(color, entityManager);
            EntityManagerUtil.commitTransaction(entityManager);
        }catch (PersistenceException e) {
            e.printStackTrace();
            EntityManagerUtil.rollbackTransaction(entityManager);
            throw new DuplicateDBException();
        }
    }

    public Color findColorByName(String color) {
        return colorDao.findByColor(color);
    }

    @Override
    public List<Color> loadAllColors() {
        return colorDao.findAll();
    }

    @Override
    public void updateColor(Color color) {
        EntityManager entityManager = null;
        try{
            entityManager = EntityManagerUtil.beginTransaction();
            colorDao.merge(color, entityManager);
            EntityManagerUtil.commitTransaction(entityManager);
        } catch (PersistenceException e)
        {
            e.printStackTrace();
            EntityManagerUtil.rollbackTransaction(entityManager);
        }
    }

    @Override
    public void deleteColor(Color color) {
        EntityManager entityManager = null;
        try {
            entityManager = EntityManagerUtil.beginTransaction();
            colorDao.remove(color, entityManager);
            EntityManagerUtil.commitTransaction(entityManager);
        } catch (PersistenceException ex) {
            ex.printStackTrace();
            EntityManagerUtil.rollbackTransaction(entityManager);
        }
    }
}
