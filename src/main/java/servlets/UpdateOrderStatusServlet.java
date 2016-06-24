package servlets;

import Util.ServicesUtil;
import entity.Order;
import enums.StatusOrder;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class UpdateOrderStatusServlet extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        Order order = ServicesUtil.getOrderService().
                findOrderById(Long.parseLong(req.getParameter("order_id")));
        StatusOrder newOrderStatus = StatusOrder.valueOf(req.getParameter("order_status"));
        order.setStatusOrder(newOrderStatus);
        ServicesUtil.getOrderService().updateOrder(order);
        resp.sendRedirect("admin/orderList.jsp");
    }
}

