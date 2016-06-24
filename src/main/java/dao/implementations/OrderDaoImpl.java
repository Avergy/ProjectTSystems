package dao.implementations;

import Util.EntityManagerUtil;
import dao.interfaces.OrderDao;
import entity.Order;
import entity.User;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;


public class OrderDaoImpl extends AbstractGenericDao implements OrderDao {

    final static Logger logger = Logger.getLogger(Order.class.getName());

    public OrderDaoImpl() {
        super();
        setEntityClass(Order.class);
    }

    @Override
    public List<Order> findByUser(User user) {
        logger.info("Find orders by user...");
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Query query = entityManager.createQuery("Select o FROM Order o WHERE o.user = :user");
        query.setParameter("user", user);
        List<Order> orders = findMany(query);
        entityManager.close();
        logger.info("Orders has been found.");
        return orders;
    }
}
