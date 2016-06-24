package servlets;

import cart.ShoppingCartManagerImpl;
import cart.ShoppingCartManager;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ClearCartServlet extends HttpServlet {



    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        clearCartAndCookies(req, resp);
        resp.sendRedirect("/cart.jsp");
    }

    public static void clearCartAndCookies(HttpServletRequest req, HttpServletResponse resp) {
        ShoppingCartManager shoppingCartManager = (ShoppingCartManagerImpl) req.getSession().getAttribute("cartManager");

        if (shoppingCartManager != null) {
            shoppingCartManager.clearCart();
        }

        CartServlet.deleteCartCookies(req, resp);

        req.setAttribute("cartManager", shoppingCartManager);
    }
}
