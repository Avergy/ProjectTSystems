package servlets;

import services.implementations.UserServiceImpl;
import services.interfaces.UserService;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.io.PrintWriter;

/**
 * Created by Siry on 05.06.2016.
 */
public class LoginServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {

        req.getRequestDispatcher("login.jsp").forward(req, resp);
        //resp.setContentType("login.jsp");
        //PrintWriter out = resp.getWriter();
        //out.print("<h1>Hello Servlet</h1>");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        // tmp Здесь проверяем введенные данные
        // отправляем на соответсвующую страницу
        ServletContext servletContext = getServletContext();
        RequestDispatcher requestDispatcher;
        if (req.getParameter("log_in")!=null){
            UserService userService = new UserServiceImpl();
            if (userService.checkLoginForm(req.getParameter("login"), req.getParameter("password")))
                resp.sendRedirect("successLogin.jsp");
            else
                resp.sendRedirect("registration.jsp");
               // req.getRequestDispatcher("registration.jsp").forward(req, resp);
        } else if (req.getParameter("registration")!=null) {
            resp.sendRedirect("registration.jsp");
            //servletContext.getRequestDispatcher("registration.jsp").forward(req, resp);
        }
    }


}
