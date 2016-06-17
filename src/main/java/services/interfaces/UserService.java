package services.interfaces;

import entity.User;


public interface UserService {

    void addNewUser(User user);

    User readUser(long id);

    User updateUser(User user);

    void deleteUser(long id);

    User checkLoginForm(String login, String password);

    boolean emailInDB(String email);

}
