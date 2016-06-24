package Util;

import services.implementations.*;
import services.interfaces.*;

public class ServicesUtil {

    private static BrandService brandService;
    private static ColorService colorService;
    private static OrderService orderService;
    private static OrderItemService orderItemService;
    private static PhoneService phoneService;
    private static RoleService roleService;
    private static UserService userService;
    private static UserAddressService userAddressService;

    public static BrandService getBrandService() {
        if (brandService == null) brandService = new BrandServiceImpl();
        return brandService;
    }

    public static ColorService getColorService() {
        if (colorService == null) colorService = new ColorServiceImpl();
        return colorService;
    }

    public static OrderService getOrderService() {
        if (orderService == null) orderService = new OrderServiceImpl();
        return orderService;
    }

    public static OrderItemService getOrderItemService() {
        if (orderItemService == null) orderItemService = new OrderItemServiceImpl();
        return orderItemService;
    }

    public static PhoneService getPhoneService() {
        if (phoneService == null) phoneService = new PhoneServiceImpl();
        return phoneService;
    }

    public static RoleService getRoleService() {
        if (roleService == null) roleService = new RoleServiceImpl();
        return roleService;
    }

    public static UserService getUserService() {
        if (userService == null) userService = new UserServiceImpl();
        return userService;
    }

    public static UserAddressService getUserAddressService() {
        if (userAddressService == null) userAddressService = new UserAddressServiceImpl();
        return userAddressService;
    }
}
