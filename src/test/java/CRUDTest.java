import dao.implementations.UserDaoImpl;
import dao.interfaces.UserDao;
import entity.Role;
import entity.User;
import org.junit.Ignore;
import org.junit.Test;
import services.implementations.UserServiceImpl;

import java.util.Date;

/**
 * Created by Siry on 31.05.2016.
 */
public class CRUDTest {

    private UserDao userDao;
    private UserServiceImpl userService;


    //@Ignore
    @Test
    public void UserDao()
    {
        // create user
        User user = new User();
        user.setLogin("Admin");
        user.setFirstName("AdminFirstName");
        user.setSecondName("AdminSecondName");
        Date date = new Date(1991, 9, 4);
        user.setBirthday(date);
        Role role = new Role();
        role.setId(2);
        role.setRole("Employee");
        user.setRole(role);
        user.setEmail("admin@admin.com");
        user.setPassword("admin");

        //userDao = new UserDaoImpl();
        userService = new UserServiceImpl();
        //userService.setUserDao(userDao);

        //userService.addNewUser(user);

        //System.out.println(userService.readUser(1));

        //user.setId(1);
        //user.setPassword("adminka");
        //userService.updateUser(user);

        //System.out.println(userService.loginInDB(user.getLogin()));

        userService.deleteUser(1);


    }
}
