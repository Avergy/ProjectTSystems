package services.implementations;

import dao.implementations.UserAddressDaoImpl;
import dao.implementations.UserDaoImpl;
import dao.interfaces.UserAddressDao;
import entity.User;
import entity.UserAddress;
import services.interfaces.UserAddressService;

import java.util.List;

public class UserAddressServiceImpl implements UserAddressService {

    UserAddressDao addressDao = new UserAddressDaoImpl();

    public UserAddressDao getAddressDao() {
        return addressDao;
    }

    public void setAddressDao(UserAddressDao addressDao) {
        this.addressDao = addressDao;
    }

    @Override
    public void addNewAddress(UserAddress userAddress) {
        addressDao.create(userAddress);
    }

    @Override
    public UserAddress loadAddress(long id) {
        return (UserAddress) addressDao.findById(id);
    }

    @Override
    public UserAddress updateAddress(UserAddress userAddress) {
        return (UserAddress) addressDao.merge(userAddress);
    }

    @Override
    public List<UserAddress> getAllUserAddress(User user) {
        return addressDao.findAllUserAddress(user);
    }
}
