package servlets;

import Util.ServicesUtil;
import entity.Color;
import exceptions.DuplicateDBException;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

public class ModifyColorServlet extends HttpServlet {
    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        String url = "/admin/modifyColor.jsp";
        String error = "/error/duplicate.jsp";

        if (req.getParameter("edit") != null)
        {
            String value = req.getParameter("select_color");
            if (value.equals("add new color"))
            {
                Color color = new Color();
                color.setColor(req.getParameter("new_color_name"));
                try {
                    ServicesUtil.getColorService().addNewColor(color);
                } catch (DuplicateDBException e) {
                    e.printStackTrace();
                    url = error;
                }
            } else {
                Color color = ServicesUtil.getColorService().findColorByName(value);
                color.setColor(req.getParameter("new_color_name"));
                ServicesUtil.getColorService().updateColor(color);
            }

        } else if (req.getParameter("delete") != null)
        {
            String value = req.getParameter("select_color");
            if (!value.equals("add new color"))
            {
                Color color = ServicesUtil.getColorService().findColorByName(value);
                ServicesUtil.getColorService().deleteColor(color);
            }
        }

        resp.sendRedirect(url);
    }
}
