package dao.interfaces;

import entity.User;

/**
 * Created by Siry on 31.05.2016.
 */
public interface UserDao extends GeneralDao {

    User findByLogin(String login);

    User findByEmail(String email);
}
