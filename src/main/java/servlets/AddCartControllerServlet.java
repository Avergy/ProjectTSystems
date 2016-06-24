package servlets;

import cart.ShoppingCart;
import entity.OrderItem;
import entity.Phone;
import entity.User;
import services.implementations.PhoneServiceImpl;
import services.interfaces.PhoneService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;


public class AddCartControllerServlet extends HttpServlet {

    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userPath = req.getServletPath();

        String url = "/phoneList?all";

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");

        if (userPath.equals("/addToCart")) {
            ShoppingCart cart = (ShoppingCart) session.getAttribute("cart");
            PhoneService phoneService = new PhoneServiceImpl();
            if (cart == null) {
                cart = new ShoppingCart();
                cart.setUser(user);
                CartServlet.fillFromCookies(req, cart);
                session.setAttribute("cart", cart);
            }
            String idString = req.getQueryString();
            if (idString != null) {
                long id = Long.parseLong(idString);
                Phone phone = phoneService.loadPhone(id);
                int quantity = 1;
                List<OrderItem> orderItems = cart.getOrderItems();
                boolean isPhoneInCart = false;
                for (OrderItem orderItem: orderItems) {
                    if (orderItem.getPhone().equals(phone)) {
                        quantity += orderItem.getQuantity();
                        orderItem.setQuantity(quantity);
                        isPhoneInCart = true;
                        break;
                    }

                }
                if (!isPhoneInCart) {
                    OrderItem orderItem = new OrderItem();
                    orderItem.setPhone(phone);
                    orderItem.setQuantity(quantity);
                    orderItems.add(orderItem);
                }
                cart.setOrderItems(orderItems);
                session.setAttribute("cart", cart);
                CartServlet.phoneToCartCookie(req, resp, phone.getId(), quantity);
            }

        }

        req.getRequestDispatcher(url).forward(req,resp);

    }
}
