package services.checkRole.implementations;

import dao.interfaces.PositionDao;
import entity.Position;
import services.checkRole.interfaces.PositionService;

/**
 * Created by Siry on 01.06.2016.
 */
public class PositionServiceImpl implements PositionService {

    private PositionDao positionDao;

    public PositionServiceImpl() {
    }

    public PositionServiceImpl(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    public PositionDao getPositionDao() {
        return positionDao;
    }

    public void setPositionDao(PositionDao positionDao) {
        this.positionDao = positionDao;
    }

    public void createNewPosition(Position position) {

    }

    public Position readPosition(int id) {
        return (Position) positionDao.findById(id);
    }

    public void updatePosition(Position position) {

    }

    public void deletePosition(Position position) {

    }
}
