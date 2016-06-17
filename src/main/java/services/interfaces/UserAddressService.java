package services.interfaces;

import entity.User;
import entity.UserAddress;

import java.util.List;


public interface UserAddressService {

    void addNewAddress(UserAddress userAddress);

    UserAddress loadAddress(long id);

    UserAddress updateAddress(UserAddress userAddress);

    List<UserAddress> getAllUserAddress(User user);
}
