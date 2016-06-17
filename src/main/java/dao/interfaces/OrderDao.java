package dao.interfaces;

import entity.Order;
import entity.User;

import java.util.List;

/**
 * Created by Siry on 16.06.2016.
 */
public interface OrderDao extends GenericDao {

    List<Order> findByUser(User user);
}
