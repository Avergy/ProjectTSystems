package servlets;

import Util.ServicesUtil;
import cart.ShoppingCartManager;
import entity.Phone;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;


public class RemoveOrderItemServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        Phone phone = ServicesUtil.getPhoneService().findPhoneById(Long.parseLong(req.getParameter("id")));
        ShoppingCartManager shoppingCartManager = (ShoppingCartManager) req.getSession().getAttribute("cartManager");
        shoppingCartManager.removeOrderItem(phone);
        CartServlet.deleteOrderLineCookie(phone.getId(), req, resp);

        req.setAttribute("cartManager", shoppingCartManager);
        resp.sendRedirect("/cart.jsp");
    }
}
