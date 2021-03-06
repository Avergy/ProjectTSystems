package servlets;

import Util.ServicesUtil;
import entity.Brand;
import entity.Phone;
import entity.User;
import services.implementations.*;
import services.interfaces.BrandService;
import services.interfaces.PhoneService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

public class ControllerServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String userPath = req.getServletPath();

        String keyPhonesList = "phonesList";
        String keyOrdersList = "ordersList";

        String url = "/WEB-INF/" + userPath +".jsp";

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");


        if (userPath.equals("/phoneList")) {
            BrandService brandService = new BrandServiceImpl();
            PhoneService phoneService = new PhoneServiceImpl();
            List<Phone> phones;
            String brandName = req.getQueryString();
            if (brandName != null) {
                if (brandName.equals("all"))
                    req.setAttribute(keyPhonesList, phoneService.loadAllPhones());
                else {
                    Brand  brand = brandService.findByBrandName(brandName);
                    req.setAttribute("brand", brand);
                    phones = phoneService.loadPhonesByBrand(brand);
                    req.setAttribute(keyPhonesList, phones);
                }
            }
        }

        else if (userPath.equals("/phone"))
        {
            PhoneService phoneService = new PhoneServiceImpl();
            String idString = req.getQueryString();
            if (idString != null)
            {
                long id = Long.parseLong(idString);
                Phone phone = phoneService.loadPhone(id);
                req.setAttribute("phone", phone);
            }

        }

        else if (userPath.equals("/ordersList")) {
            String userId = req.getQueryString();
            if (userId.equals("all") && user.getRole().getRole().equals("Admin")) {
                url = "/admin/orderList.jsp";
                req.setAttribute(keyOrdersList, ServicesUtil.getOrderService().getAllOrders());
            } else {
                url = "/user/" + userPath +".jsp";
                if (user != null)
                    req.setAttribute(keyOrdersList, user.getOrders());

            }
        }

        else if (userPath.equals("/myAddressList"))
        {
            url = "/user/" + userPath +".jsp";
            if (user != null)
                req.setAttribute("myAddressList", user.getAddresses());
        }

        req.getRequestDispatcher(url).forward(req,resp);

    }
}
