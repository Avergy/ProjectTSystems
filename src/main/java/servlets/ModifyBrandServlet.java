package servlets;

import Util.ServicesUtil;
import entity.Brand;
import exceptions.DuplicateDBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModifyBrandServlet extends HttpServlet {

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "/admin/modifyBrand.jsp";
        String error = "/error/Duplicate.jsp";

        if (req.getParameter("edit") != null)
        {
            String value = req.getParameter("select_brand");
            if (value.equals("add new brand"))
            {
                Brand brand = new Brand();
                brand.setBrand(req.getParameter("new_brand_name"));
                try {
                    ServicesUtil.getBrandService().addNewBrand(brand);
                } catch (DuplicateDBException e) {
                    e.printStackTrace();
                    url = error;
                }
            } else {
                Brand brand = ServicesUtil.getBrandService().findByBrandName(value);
                brand.setBrand(req.getParameter("new_brand_name"));
                ServicesUtil.getBrandService().updateBrand(brand);
            }

        } else if (req.getParameter("delete") != null)
        {
            String value = req.getParameter("select_brand");
            if (!value.equals("add new brand"))
            {
                Brand brand = ServicesUtil.getBrandService().findByBrandName(value);
                ServicesUtil.getBrandService().deleteBrand(brand);
            }
        }

        resp.sendRedirect(url);
    }
}
