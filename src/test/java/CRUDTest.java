import dao.implementations.UserDaoImpl;
import dao.interfaces.UserDao;
import entity.Role;
import entity.User;
import org.junit.Ignore;
import org.junit.Test;
import services.implementations.UserServiceImpl;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * Created by Siry on 31.05.2016.
 */
public class CRUDTest {

    private UserDao userDao;
    private UserServiceImpl userService;


    @Ignore
    @Test
    public void UserDao()
    {
        // create user
        User user = new User();
        user.setLogin("User4");
        user.setFirstName("AdminFirstName");
        user.setSecondName("AdminSecondName");
        Calendar date = new GregorianCalendar(1991, 9, 4);
        user.setBirthday(date.getTime());
        user.setEmail("user4@admin.com");
        user.setPassword("admin");

        //userDao = new UserDaoImpl();
        userService = new UserServiceImpl();
        //userService.setUserDao(userDao);

        userService.addNewUser(user);

        //System.out.println(userService.readUser(1));

        //user.setId(1);
        //user.setPassword("adminka");
        //userService.updateUser(user);

        //System.out.println(userService.loginInDB(user.getLogin()));

        userService.deleteUser(1);


    }
}
