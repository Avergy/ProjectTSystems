package dao.interfaces;

import entity.Color;

public interface ColorDao extends GenericDao {

    Color findByColor(String color);
}
