package servlets;

import Util.ServicesUtil;
import cart.ShoppingCart;
import entity.OrderItem;

import javax.servlet.ServletException;
import javax.servlet.http.*;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;


public class CartServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/cart.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

    }



    public static void phoneToCartCookie(HttpServletRequest request, HttpServletResponse response, long id, int quantity) {

        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            String value = cookie.getValue();
            if (value.contains("fufu")) {
                String[] arr = value.split("fufu");
                long phoneId = Long.parseLong(arr[0]);
                if (phoneId == id) {
                    cookie.setMaxAge(0);
                }
            }
        }
        Cookie cookie = new Cookie(String.valueOf(id), request.getSession().getAttribute("login") + "fifi" + id + "fifi" + ++quantity);
        cookie.setMaxAge(60 * 60 * 24);
        response.addCookie(cookie);
    }

    public static void fillFromCookies(HttpServletRequest request, ShoppingCart cart) {

        Cookie[] cookies = request.getCookies();

        List<OrderItem> orderItems = new ArrayList<>();

        if (cookies != null) {
            String login = (String) request.getSession().getAttribute("login");
            long id;
            int quantity;
            for (Cookie cookie : cookies) {
                String value = cookie.getValue();
                if (value.contains("fifi")) {
                    String[] cookieContent = value.split("fifi");
                    if (cookieContent[0].equals(login)) {
                        id = Long.parseLong(cookieContent[1]);
                        quantity = Integer.parseInt(cookieContent[2]);
                        OrderItem item = new OrderItem();
                        item.setQuantity(quantity);
                        item.setPhone(ServicesUtil.getPhoneService().findPhoneById(id));
                        orderItems.add(item);
                    }

                }
            }
        }
        if (!orderItems.isEmpty()) {
            cart.setOrderItems(orderItems);
        }

    }

    public static void deleteCartCookies(HttpServletRequest request, HttpServletResponse response) {
        Cookie[] cookies = request.getCookies();
        String login = (String) request.getSession().getAttribute("login");
        for (Cookie cookie : cookies) {
            String value = cookie.getValue();
            if (value.contains("fifi")) {
                String[] cookieContent = value.split("fifi");
                if (cookieContent[0].equals(login)) {
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    response.addCookie(cookie);
                }
            }
        }
    }

    public static void deleteOrderLineCookie(long id, HttpServletRequest req, HttpServletResponse resp) {
        Cookie[] cookies = req.getCookies();
        String login = (String) req.getSession().getAttribute("login");
        for (Cookie cookie : cookies) {
            String value = cookie.getValue();
            if (value.contains("fifi")) {
                String[] cookieContent = value.split("fifi");
                if ((cookieContent[0].equals(login) || cookieContent[0].equals("Guest"))
                        && id == Long.parseLong(cookieContent[1])) {
                    cookie.setMaxAge(0);
                    cookie.setPath("/");
                    resp.addCookie(cookie);
                }
            }
        }
    }
}
