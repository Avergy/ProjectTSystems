package servlets;

import entity.Role;
import entity.User;
import services.implementations.UserServiceImpl;
import services.interfaces.UserService;

import javax.servlet.ServletContext;
import javax.servlet.ServletException;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;
import java.util.Date;

/**
 * Created by Siry on 04.06.2016.
 */
public class AddUser extends HttpServlet {

    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.setContentType("");
    }

    public void doPost(HttpServletRequest request, HttpServletResponse response)
            throws ServletException, IOException {
        ServletContext ctx = getServletContext();
        if (request.getParameter("register") != null){
            User newUser = new User();
            newUser.setLogin(request.getParameter("login"));
            newUser.setFirstName(request.getParameter("firstName"));
            newUser.setSecondName(request.getParameter("secondName"));
            Date date = new Date(request.getDateHeader("birthday"));
            newUser.setBirthday(date);
            newUser.setEmail(request.getParameter("email"));
            newUser.setPassword(request.getParameter("password"));
            Role role = new Role();
            role.setId(1);
            role.setRole("Client");
            newUser.setRole(role);
            UserService userService = new UserServiceImpl();
            newUser = userService.addNewUser(newUser);
            if ( newUser != null)
            {
               // this.forward("/successRegistration.jsp", request, response);
            }
            //else
             //   this.forward("/registration.jsp", request, response);


            //ctx.setAttribute("user", newUser);
        } else if (request.getParameter("log_in") != null){
            //this.forward("/login.jsp", request, response);
        }
    }
}