package services.composite.interfaces;

import entity.User;

/**
 * Created by Siry on 01.06.2016.
 */
public interface UserService {

    void createNewUser(User user);

    void readUser(User user);

    void updateUser(User user);

    void deleteUser(User user);


}
