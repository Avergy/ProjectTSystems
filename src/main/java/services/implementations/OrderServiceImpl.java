package services.implementations;

import dao.implementations.OrderDaoImpl;
import dao.interfaces.OrderDao;
import entity.Order;
import entity.User;
import services.interfaces.OrderService;

import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = new OrderDaoImpl();

    public OrderDao getOrderDao() {
        return orderDao;
    }

    public void setOrderDao(OrderDao orderDao) {
        this.orderDao = orderDao;
    }

    @Override
    public void addNewOrder(Order order) {
        orderDao.create(order);
    }

    @Override
    public Order loadOrder(long id) {
        return (Order) orderDao.findById(id);
    }

    @Override
    public Order updateOrder(Order order) {
        return (Order) orderDao.merge(order);
    }

    @Override
    public List<Order> getUserOrders(User user) {
        return orderDao.findByUser(user);
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }
}
