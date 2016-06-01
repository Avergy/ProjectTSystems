package services.composite.implementations;

import dao.interfaces.UserDao;
import entity.User;
import services.composite.interfaces.UserService;

/**
 * Created by Siry on 01.06.2016.
 */
public class UserServiceImpl implements UserService {

    private UserDao userDao;

    public UserServiceImpl() {
    }

    public UserServiceImpl(UserDao userDao) {
        this.userDao = userDao;
    }

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }

    public void createNewUser(User user) {

    }

    public void readUser(User user) {

    }

    public void updateUser(User user) {
        userDao.merge(User.class);
    }

    public void deleteUser(User user) {

    }
}
