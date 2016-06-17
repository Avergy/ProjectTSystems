package servlets;

import entity.User;
import services.implementations.UserServiceImpl;
import services.interfaces.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;


public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("/WEB-INF/login.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        ServletContext context = getServletContext();
        HttpSession session = req.getSession();
        if (req.getParameter("log_in")!=null){
            UserService userService = new UserServiceImpl();
            User user = userService.checkLoginForm(req.getParameter("j_username"), req.getParameter("j_password"));
            if ( user != null) {
                session.setAttribute("user", user);
                session.setAttribute("role", user.getRole().getRole());
                resp.sendRedirect("/profile");
            }
            else
                resp.sendRedirect("login.jsp");
        } else if (req.getParameter("registration")!=null) {
            resp.sendRedirect("/registration");
        }
    }



}
