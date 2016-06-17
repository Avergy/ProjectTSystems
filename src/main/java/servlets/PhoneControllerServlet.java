package servlets;

import entity.User;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class PhoneControllerServlet extends HttpServlet {


    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String userPath = req.getServletPath();


        String url = "/WEB-INF/" + userPath +".jsp";

        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");


        if (userPath.equals("/newPhone")) {
            //TODO
        }

        else if (userPath.equals("/editPhone"))
        {
            //TODO
        }


        req.getRequestDispatcher(url).forward(req,resp);


    }
}
