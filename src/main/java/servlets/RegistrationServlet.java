package servlets;

import entity.Role;
import entity.User;
import services.implementations.RoleServiceImpl;
import services.implementations.UserServiceImpl;
import services.interfaces.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Siry on 05.06.2016.
 */
public class RegistrationServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        //ServletContext servletContext =getServletContext();
       // RequestDispatcher requestDispatcher;
       // requestDispatcher = servletContext.getRequestDispatcher("registration.jsp");
       // requestDispatcher.forward(req, resp);
        req.getRequestDispatcher("registration.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext servletContext =getServletContext();
        RequestDispatcher requestDispatcher;
        if (req.getParameter("register") != null){
            User newUser = new User();
            newUser.setLogin(req.getParameter("login"));
            newUser.setFirstName(req.getParameter("firstName"));
            newUser.setSecondName(req.getParameter("secondName"));
            Date date = new Date(req.getDateHeader("birthday"));
            newUser.setBirthday(date);
            newUser.setEmail(req.getParameter("email"));
            newUser.setPassword(req.getParameter("password"));
            Role role = new RoleServiceImpl().readRole(1);
            newUser.setRole(role);
            UserService userService = new UserServiceImpl();
            newUser = userService.addNewUser(newUser);
            if (newUser != null)
            {
                resp.sendRedirect("successRegistration.jsp");
            }
            else
            {
                resp.sendRedirect("errorRegistration.htm");
            }
        } else if (req.getParameter("cancel") != null){
            resp.sendRedirect("login.jsp");
        }
    }
}
