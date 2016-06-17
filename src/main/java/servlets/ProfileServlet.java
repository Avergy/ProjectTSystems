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
import java.util.Calendar;
import java.util.GregorianCalendar;


public class ProfileServlet extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        req.getRequestDispatcher("/WEB-INF/profile.jsp").forward(req, resp);
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        User user = (User) session.getAttribute("user");
        if ((req.getParameter("edit_profile") != null) &&
                (user.getPassword().equals(req.getParameter("password")))){
            String newFirstName = req.getParameter("firstName");
            if (!newFirstName.equals(""))
                user.setFirstName(newFirstName);
            String newSecondName = req.getParameter("secondName");
            if (!newSecondName.equals(""))
                user.setSecondName(newSecondName);
            String newDateString = req.getParameter("birthday");
            Calendar date;
            try{
                int day = Integer.parseInt(newDateString.substring(0, 2));
                int month = Integer.parseInt(newDateString.substring(3, 5)) - 1;
                int year = Integer.parseInt(newDateString.substring(6, newDateString.length()));
                date = new GregorianCalendar(year, month, day);
            }catch (Exception e)
            {
                date = null;
            }
            if (date != null)
                user.setBirthday(date.getTime());
            String newEmail = req.getParameter("email");
            if (!newEmail.equals(""))
                user.setEmail(newEmail);
            String newPassword = req.getParameter("new_password");
            if (!newPassword.equals(""))
                user.setPassword(newPassword);
            UserService userService = new UserServiceImpl();
            user = userService.updateUser(user);

            if (user != null)
                session.setAttribute("user", user);
            resp.sendRedirect("/profile");
        } else if ((req.getParameter("delete_profile") != null) &&
                (user.getPassword().equals(req.getParameter("password")))){
            UserService userService = new UserServiceImpl();
            userService.deleteUser(user.getId());
            resp.sendRedirect("login.jsp");
        } else if (req.getParameter("log_out") != null){
            session.setAttribute("user", null);
            resp.sendRedirect("/login");
        }

        else {
            resp.sendRedirect("/profile");
        }
    }
}
