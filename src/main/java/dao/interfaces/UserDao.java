package dao.interfaces;

import entity.User;
import exceptions.NotFoundInDBException;

public interface UserDao extends GenericDao {

    User findByLogin(String login) throws NotFoundInDBException;

}
