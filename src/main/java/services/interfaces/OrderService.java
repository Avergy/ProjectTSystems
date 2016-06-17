package services.interfaces;

import entity.Order;
import entity.User;

import java.util.List;

/**
 * Created by Siry on 16.06.2016.
 */
public interface OrderService {

    void addNewOrder(Order order);

    Order loadOrder(long id);

    Order updateOrder(Order order);

    List<Order> getUserOrders(User user);

    List<Order> getAllOrders();
}
