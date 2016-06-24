package services.implementations;

import Util.DAOsUtil;
import Util.EntityManagerUtil;
import dao.implementations.UserAddressDaoImpl;
import dao.implementations.UserDaoImpl;
import dao.interfaces.UserAddressDao;
import entity.User;
import entity.UserAddress;
import services.interfaces.UserAddressService;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceException;
import java.util.List;

public class UserAddressServiceImpl implements UserAddressService {

    UserAddressDao addressDao = DAOsUtil.getUserAddressDao();


}
