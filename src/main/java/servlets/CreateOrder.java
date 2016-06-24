package servlets;

import Util.ServicesUtil;
import entity.Order;
import entity.OrderItem;
import entity.User;
import entity.UserAddress;
import enums.Delivery;
import enums.Payment;
import enums.StatusOrder;
import enums.StatusPayment;
import exceptions.NotEnoughException;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.Date;
import java.util.LinkedList;
import java.util.List;

public class CreateOrder extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp)
            throws ServletException, IOException {

        String status = "cart.jsp#order_popup_ok";
        String notOk = "cart.jsp#order_popup_not_ok";

        HttpSession session = req.getSession(false);
        User user = (User) session.getAttribute("user");

        List<OrderItem> orderItems = (List<OrderItem>) req.getSession().getAttribute("orderItems");


        Order order = new Order();

        for (OrderItem item : orderItems) {

            int inCartQuantity = Integer.parseInt(req.getParameter("quantity" + item.getPhone().getId()));
            int inStoreQuantity = ServicesUtil.getPhoneService().loadPhone(item.getPhone().getId()).getQuantityStock();
            if (inCartQuantity > inStoreQuantity) {
                try {
                    throw new NotEnoughException();
                } catch (NotEnoughException e) {
                    e.printStackTrace();
                    status = notOk;
                }
            } else {
                item.setQuantity(inCartQuantity);
                item.setOrder(order);
            }
        }

        try {
            List<OrderItem> copy = new LinkedList<>();
            for (OrderItem item: orderItems){
                copy.add(item);
            }
            order.setOrderItems(copy);
            order.setUser(user);
            order.setDate(new Date(System.currentTimeMillis()));
            order.setDelivery(Delivery.valueOf(req.getParameter("shipping_type")));
            order.setPayment(Payment.valueOf(req.getParameter("payment_type")));
            order.setStatusOrder(StatusOrder.WAITING_FOR_PAYMENT);
            order.setStatusPayment(StatusPayment.WAITING_FOR_PAYMENT);

            UserAddress userAddress = new UserAddress();
            userAddress.setAddress(req.getParameter("new_address_name"));
            userAddress.setUser(user);
            order.setUserAddress(userAddress);
            long cost = 0;// = Long.parseLong(req.getParameter("cost"));
            for(OrderItem orderItem: copy)
            {
                cost += orderItem.getPhone().getPrice()*orderItem.getQuantity();
            }
            order.setCost(cost);
            ServicesUtil.getOrderService().addNewOrder(order);
            ClearCartServlet.clearCartAndCookies(req, resp);


        } catch (Exception ex) {
            ex.printStackTrace();
            status = notOk;
        } finally {
            resp.sendRedirect(status);
        }

    }
}
