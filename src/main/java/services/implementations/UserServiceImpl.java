package services.implementations;

import Util.DAOsUtil;
import Util.EntityManagerUtil;
import Util.ServicesUtil;
import dao.interfaces.OrderDao;
import dao.interfaces.UserDao;
import entity.Order;
import entity.Phone;
import entity.Role;
import entity.User;
import exceptions.NotFoundInDBException;
import org.apache.log4j.Logger;
import services.interfaces.UserService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import javax.persistence.Query;
import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;


public class UserServiceImpl implements UserService {

    private UserDao userDao = DAOsUtil.getUserDao();
    private OrderDao orderDao = DAOsUtil.getOrderDao();

    final static Logger logger = Logger.getLogger(UserServiceImpl.class.getName());

    public void addNewUser(User user) {
        logger.info("Add new user to DB...");
        EntityManager entityManager = null;
        try{
            entityManager = EntityManagerUtil.beginTransaction();
            Role role = ServicesUtil.getRoleService().readRole(1);
            user.setRole(role);

            EntityManagerUtil.commitTransaction(entityManager);
            logger.info("New user has been added.");
        }catch (PersistenceException e)
        {
            EntityManagerUtil.rollbackTransaction(entityManager);
            logger.error("New user has not been added.");
        }



    }


    public void updateUser(User user) {
       EntityManager entityManager = null;
        try{
            entityManager = EntityManagerUtil.beginTransaction();
            userDao.merge(user, entityManager);
            EntityManagerUtil.commitTransaction(entityManager);
        }catch (PersistenceException e)
        {
            e.printStackTrace();
            EntityManagerUtil.rollbackTransaction(entityManager);
        }
    }



    @Override
    public User findByLogin(String login) throws NotFoundInDBException {
        return userDao.findByLogin(login);
    }

    @Override
    public User findById(long id) {
        return (User) userDao.findById(id);
    }



    @Override
    public Map<Phone, Integer> getTopTenPhones() {

        Map<Phone, Integer> topPhones = new HashMap<>();

        String sql = "select orderitems.idPhone, sum(orderitems.Quantity) FROM orderitems GROUP BY idPhone ORDER BY sum(orderitems.Quantity) DESC LIMIT 10";
        List<Object[]> resultList = EntityManagerUtil.getEntityManager().createNativeQuery(sql).getResultList();

        for (Object[] result : resultList) {
            BigInteger idPhone = (BigInteger) result[0];
            long id = idPhone.longValue();

            BigDecimal totalSold = (BigDecimal) result[1];
            int summ = totalSold.intValue();

            topPhones.put(ServicesUtil.getPhoneService().findPhoneById(id), summ);
        }

        return sortByValue(topPhones);
    }

    @Override
    public Map<User, Long> getTopTenUsers() {

        Map<User, Long> topUsers = new HashMap<>();

        String sql = "select orders.idUser, sum(orders.Cost) FROM orders GROUP BY idUser ORDER BY sum(orders.Cost) DESC LIMIT 10";

        List<Object[]> resultList = EntityManagerUtil.getEntityManager().createNativeQuery(sql).getResultList();

        for (Object[] result : resultList) {
            BigInteger clientId = (BigInteger) result[0];
            long id = clientId.longValue();

            BigDecimal clientSum = (BigDecimal) result[1];
            long summ = clientSum.longValue();

            topUsers.put(ServicesUtil.getUserService().findById(id), summ);
        }

        return sortByValue(topUsers);
    }

    @Override
    public List<Order> getOrdersPerPeriod(Date periodStart, Date periodEnd) {
        List<Order> orders = null;
        String sql = "SELECT o FROM Order o WHERE o.date >= :periodStart AND o.date <= :periodEnd";
        EntityManager em = EntityManagerUtil.getEntityManager();
        Query query = em.createQuery(sql).
                setParameter("periodStart", periodStart).setParameter("periodEnd", periodEnd);
        orders = orderDao.findMany(query);
        em.close();
        return orders;
    }

    private static <K, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, new Comparator<Map.Entry<K, V>>() {
            @Override
            public int compare(Map.Entry<K, V> o1, Map.Entry<K, V> o2) {
                return (o2.getValue()).compareTo(o1.getValue());
            }
        });

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}
