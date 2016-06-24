package services.interfaces;


import entity.Color;
import exceptions.DuplicateDBException;

import java.util.List;


public interface ColorService {

    void addNewColor(Color color) throws DuplicateDBException;

    Color findColorByName(String color);

    List<Color> loadAllColors();

    void updateColor(Color color);

    void deleteColor(Color color);

}
