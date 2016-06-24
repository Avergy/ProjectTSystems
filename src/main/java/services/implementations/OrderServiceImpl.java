package services.implementations;

import Util.DAOsUtil;
import Util.EntityManagerUtil;
import dao.interfaces.OrderDao;
import dao.interfaces.PhoneDao;
import entity.Order;
import entity.OrderItem;
import services.interfaces.OrderService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class OrderServiceImpl implements OrderService {

    private OrderDao orderDao = DAOsUtil.getOrderDao();
    private PhoneDao phoneDao = DAOsUtil.getPhoneDao();

    @Override
    public boolean addNewOrder(Order order) {
        EntityManager entityManager = null;
        boolean result = true;
        try{
            entityManager = EntityManagerUtil.beginTransaction();
            for (OrderItem orderItem: order.getOrderItems())
            {
                long id = orderItem.getPhone().getId();
                int quantity = orderItem.getQuantity();
                result = result && phoneDao.setPhoneQuantity(id, quantity, entityManager);
            }
            if (result) {
                orderDao.merge(order, entityManager);
                EntityManagerUtil.commitTransaction(entityManager);
            } else {
                EntityManagerUtil.rollbackTransaction(entityManager);
            }
        }catch (PersistenceException e)
        {
            e.printStackTrace();
            EntityManagerUtil.rollbackTransaction(entityManager);
        } finally {
            return result;
        }
    }

    @Override
    public void updateOrder(Order order) {
        EntityManager entityManager = null;
        try{
            entityManager = EntityManagerUtil.beginTransaction();
            orderDao.merge(order, entityManager);
            EntityManagerUtil.commitTransaction(entityManager);
        } catch (PersistenceException e)
        {
            e.printStackTrace();
            EntityManagerUtil.rollbackTransaction(entityManager);
        }
    }

    @Override
    public List<Order> getAllOrders() {
        return orderDao.findAll();
    }

    @Override
    public Order findOrderById(long id) {
        return (Order) orderDao.findById(id);
    }
}
