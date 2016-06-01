package services.checkRole.interfaces;

import entity.Position;

/**
 * Created by Siry on 01.06.2016.
 */
public interface PositionService {

    void createNewPosition(Position position);

    Position readPosition(int id);

    void updatePosition(Position position);

    void deletePosition(Position position);
}
