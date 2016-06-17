package dao.interfaces;

import entity.Color;

/**
 * Created by Siry on 07.06.2016.
 */
public interface ColorDao extends GenericDao {

    Color findByColor(String color);
}
