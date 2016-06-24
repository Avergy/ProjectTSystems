package dao.implementations;

import Util.EntityManagerUtil;
import dao.interfaces.UserAddressDao;
import entity.User;
import entity.UserAddress;
import org.apache.log4j.Logger;

import javax.persistence.EntityManager;
import javax.persistence.Query;
import java.util.List;

public class UserAddressDaoImpl extends AbstractGenericDao implements UserAddressDao {

    final static Logger logger = Logger.getLogger(UserAddressDaoImpl.class.getName());

    public UserAddressDaoImpl() {
        super();
        setEntityClass(UserAddress.class);
    }

    @Override
    public List<UserAddress> findAllUserAddress(User user) {
        logger.info("Find user addresses in the DB...");
        EntityManager entityManager = EntityManagerUtil.getEntityManager();
        Query query = entityManager.createQuery("Select address FROM UserAddress address WHERE address.user = :user");
        query.setParameter("user", user);
        List list = findMany(query);
        entityManager.close();
        logger.info("User addresses has been found.");
        return list;
    }
}
