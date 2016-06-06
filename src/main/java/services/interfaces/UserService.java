package services.interfaces;

import entity.User;

/**
 * Created by Siry on 03.06.2016.
 */
public interface UserService {

    User addNewUser(User user);

    User readUser(long id);

    void updateUser(User user);

    void deleteUser(long id);

    boolean loginInDB(String login);

    boolean checkLoginForm(String login, String password);

    boolean emailInDB(String email);

}
