package services.interfaces;

import entity.Order;
import entity.Phone;
import entity.User;
import exceptions.NotFoundInDBException;

import java.util.Date;
import java.util.List;
import java.util.Map;


public interface UserService {

    void updateUser(User user);

    User findByLogin(String login) throws NotFoundInDBException;

    User findById(long id);


    Map<Phone, Integer> getTopTenPhones();

    Map<User, Long> getTopTenUsers();

    List<Order> getOrdersPerPeriod(Date periodStart, Date periodEnd);

}
