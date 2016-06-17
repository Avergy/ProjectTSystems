package dao.implementations;

import dao.interfaces.UserAddressDao;
import entity.User;
import entity.UserAddress;

import javax.persistence.Query;
import java.util.List;

public class UserAddressDaoImpl extends AbstractGenericDao implements UserAddressDao {

    public UserAddressDaoImpl() {
        super();
        setEntityClass(UserAddress.class);
    }

    @Override
    public List<UserAddress> findAllUserAddress(User user) {
        Query query = entityManager.createQuery("Select address FROM UserAddress address WHERE address.user = :user");
        query.setParameter("user", user);
        List list = query.getResultList();
        return list;
    }
}
