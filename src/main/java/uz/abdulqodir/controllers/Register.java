package uz.abdulqodir.controllers;

import uz.abdulqodir.dao.UserDao;
import uz.abdulqodir.models.User;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.List;
import java.util.Objects;

@WebServlet(urlPatterns = "/register")
public class Register extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        resp.sendRedirect("/jsp/register-form.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String firstName = req.getParameter("firstName");
        String lastName = req.getParameter("lastName");
        String username = req.getParameter("username");
        String password = req.getParameter("password");
        String checkPassword = req.getParameter("checkPassword");
        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();

        if (!password.equals(checkPassword)) {
            writer.println("<h1>passwords are not equal</h1>");
        } else {
            List<User> allUsers = UserDao.getAllUsers();

            for (User user : Objects.requireNonNull(allUsers)) {
                if (user.getUsername().equals(username)) {
                    writer.println("<h1>Username already exists</h1>");
                    return;
                }
            }

            UserDao.addUser(firstName, lastName, username, password);
            HttpSession session = req.getSession();
            session.setAttribute("username", username);
            session.setMaxInactiveInterval(60*5);
            resp.sendRedirect("/tasks");

        }

    }
}
