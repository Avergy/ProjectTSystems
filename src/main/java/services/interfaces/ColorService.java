package services.interfaces;


import entity.Color;


public interface ColorService {

    void addNewColor(Color color);

    Color findColorByName(String color);

}
