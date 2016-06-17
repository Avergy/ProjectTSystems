package servlets;

import entity.User;
import services.implementations.UserServiceImpl;
import services.interfaces.UserService;

import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Calendar;
import java.util.GregorianCalendar;

/**
 * Created by Siry on 05.06.2016.
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        if (req.getParameter("register") != null){
            User newUser = new User();
            newUser.setLogin(req.getParameter("login"));
            newUser.setFirstName(req.getParameter("firstName"));
            newUser.setSecondName(req.getParameter("secondName"));
            String dateString = req.getParameter("birthday");
            int year = Integer.parseInt(dateString.substring(0, 4));
            int month = Integer.parseInt(dateString.substring(5, 7)) - 1;
            int day = Integer.parseInt(dateString.substring(8, dateString.length()));
            Calendar date = new GregorianCalendar(year, month, day);
            newUser.setBirthday(date.getTime());
            newUser.setEmail(req.getParameter("email"));
            newUser.setPassword(req.getParameter("password"));
            UserService userService = new UserServiceImpl();
            userService.addNewUser(newUser);
            //newUser =
            if (newUser != null)
            {
                resp.sendRedirect("index.jsp");
            }
            else
            {
                resp.sendRedirect("registration.jsp");
            }
        } else if (req.getParameter("log_in") != null){
            resp.sendRedirect("login.jsp");
        }
    }
}
