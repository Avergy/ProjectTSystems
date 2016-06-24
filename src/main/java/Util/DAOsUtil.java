package Util;

import dao.implementations.*;
import dao.interfaces.*;


public class DAOsUtil {

    private static BrandDao brandDao;
    private static ColorDao colorDao;
    private static OrderDao orderDao;
    private static OrderItemDao orderItemDao;
    private static PhoneDao phoneDao;
    private static RoleDao roleDao;
    private static UserDao userDao;
    private static UserAddressDao userAddressDao;

    public static BrandDao getBrandDao() {
        if (brandDao == null) brandDao = new BrandDaoImpl();
        return brandDao;
    }

    public static ColorDao getColorDao() {
        if (colorDao == null) colorDao = new ColorDaoImpl();
        return colorDao;
    }

    public static OrderDao getOrderDao() {
        if (orderDao == null) orderDao = new OrderDaoImpl();
        return orderDao;
    }

    public static OrderItemDao getOrderItemDao() {
        if (orderItemDao == null) orderItemDao = new OrderItemDaoImpl();
        return orderItemDao;
    }

    public static PhoneDao getPhoneDao() {
        if (phoneDao == null) phoneDao = new PhoneDaoImpl();
        return phoneDao;
    }

    public static RoleDao getRoleDao() {
        if (roleDao == null) roleDao = new RoleDaoImpl();
        return roleDao;
    }

    public static UserDao getUserDao() {
        if (userDao == null) userDao = new UserDaoImpl();
        return userDao;
    }

    public static UserAddressDao getUserAddressDao() {
        if (userAddressDao == null) userAddressDao = new UserAddressDaoImpl();
        return userAddressDao;
    }
}
