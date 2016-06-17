package dao.implementations;

import dao.interfaces.OrderDao;
import entity.Order;
import entity.User;

import javax.persistence.Query;
import java.util.List;


public class OrderDaoImpl extends AbstractGenericDao implements OrderDao {

    public OrderDaoImpl() {
        super();
        setEntityClass(Order.class);
    }

    @Override
    public List<Order> findByUser(User user) {
        Query query = entityManager.createQuery("Select o FROM Order o WHERE o.user = :user");
        query.setParameter("user", user);
        List<Order> orders = query.getResultList();
        return orders;
    }
}
