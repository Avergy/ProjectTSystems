package dao.interfaces;

import entity.User;
import entity.UserAddress;

import java.util.List;


public interface UserAddressDao extends GenericDao {

    List<UserAddress> findAllUserAddress(User user);
}
