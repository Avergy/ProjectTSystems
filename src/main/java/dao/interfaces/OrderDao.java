package dao.interfaces;

import entity.Order;
import entity.User;

import java.util.List;

public interface OrderDao extends GenericDao {

    List<Order> findByUser(User user);
}
