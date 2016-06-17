package dao.interfaces;

import entity.User;

public interface UserDao extends GenericDao {

    User findByLogin(String login);

    User findByEmail(String email);

}
