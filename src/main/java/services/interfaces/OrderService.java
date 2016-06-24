package services.interfaces;

import entity.Order;
import entity.User;

import java.util.List;

public interface OrderService {

    boolean addNewOrder(Order order);

    Order findOrderById(long id);

    void updateOrder(Order order);

    List<Order> getAllOrders();

}
