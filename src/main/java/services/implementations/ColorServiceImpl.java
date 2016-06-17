package services.implementations;

import dao.implementations.ColorDaoImpl;
import dao.interfaces.ColorDao;
import entity.Color;
import services.interfaces.ColorService;


public class ColorServiceImpl implements ColorService {

    private ColorDao colorDao = new ColorDaoImpl();

    public ColorDao getColorDao() {
        return colorDao;
    }

    public void setColorDao(ColorDao colorDao) {
        this.colorDao = colorDao;
    }

    public void addNewColor(Color color) {
        colorDao.create(color);
    }

    public Color findColorByName(String color) {
        return colorDao.findByColor(color);
    }
}
