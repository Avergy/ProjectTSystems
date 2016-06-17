package services.implementations;

import dao.implementations.UserDaoImpl;
import dao.interfaces.UserDao;
import entity.Role;
import entity.User;
import services.interfaces.UserService;


public class UserServiceImpl implements UserService {

    private UserDao userDao = new UserDaoImpl();

    public UserDao getUserDao() {
        return userDao;
    }

    public void setUserDao(UserDao userDao) {
        this.userDao = userDao;
    }


    public void addNewUser(User user) {
        //if (loginInDB(user.getLogin())) return null;
        //if (emailInDB(user.getEmail())) return null;
        //Role role = new RoleServiceImpl().readRole(1);
        //user.setRole(role);
        userDao.create(user);
    }

    public User readUser(long id) {
        return (User) userDao.findById(id);
    }

    public User updateUser(User user) {
        return (User) userDao.merge(user);
    }

    public void deleteUser(long id) {
        User user = (User) userDao.findById(id);
        if (user != null)
            userDao.remove(user);
    }

    public boolean loginInDB(String login) {
        return userDao.findByLogin(login) != null ? true : false ;
    }


    public User checkLoginForm(String login, String password) {
        if (login == "") return null;
        if (password == "") return null;
        User user = userDao.findByLogin(login);
        if (user != null)
            if (user.getPassword().equals(password))
                return user;
        return null;
    }

    public boolean emailInDB(String email) {
        return userDao.findByEmail(email) != null ? true : false ;
    }
}
