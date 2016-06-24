package servlets;

import Util.ServicesUtil;
import entity.Order;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

public class ProceedsPerPeriod extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");

        try {
            java.util.Date startDate = format.parse(req.getParameter("start_date"));
            java.util.Date endDate = format.parse(req.getParameter("end_date"));
            java.sql.Date sqlStartDate = new java.sql.Date(startDate.getTime());
            java.sql.Date sqlEndDate = new java.sql.Date(endDate.getTime());
            List<Order> ordersPerPeriod = ServicesUtil.getUserService().getOrdersPerPeriod(sqlStartDate, sqlEndDate);
            req.getSession().setAttribute("ordersPerPeriod", ordersPerPeriod);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        resp.sendRedirect("admin/statistics.jsp");
    }
}
