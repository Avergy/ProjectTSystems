package Util;

import cart.ShoppingCartManager;
import cart.ShoppingCart;
import entity.User;
import exceptions.NotFoundInDBException;
import servlets.CartServlet;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

public class SetUtil {

    public static void setUserByLogin(String login, HttpServletRequest request) {
        HttpSession session = request.getSession();
        User user = new User();
        user.setLogin(login);
        try {
            user = ServicesUtil.getUserService().findByLogin(login);
        } catch (NotFoundInDBException e) {
            e.printStackTrace();
        }
        session.setAttribute("login", user.getLogin());
        session.setAttribute("user", user);
    }

    public static void setCartOutCookie(HttpServletRequest request, User user, ShoppingCartManager shoppingCartManager) {
        ShoppingCart cart = new ShoppingCart();
        cart.setUser(user);
        shoppingCartManager.setShoppingCart(cart);
        CartServlet.fillFromCookies(request, cart);
        request.getSession().setAttribute("cart", cart);
    }


}
