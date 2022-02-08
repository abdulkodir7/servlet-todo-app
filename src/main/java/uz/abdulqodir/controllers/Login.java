package uz.abdulqodir.controllers;

import uz.abdulqodir.dao.UserDao;
import uz.abdulqodir.models.User;
import uz.abdulqodir.utils.DbConnect;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.Objects;


@WebServlet(urlPatterns = "/login")
public class Login extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String username = (String) session.getAttribute("username");
        for (User user : Objects.requireNonNull(UserDao.getAllUsers())) {
            if (user.getUsername().equals(username)) {
                resp.sendRedirect("/tasks");
                return;
            }
        }
        resp.sendRedirect("/jsp/login-form.jsp");
    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();

        String username = req.getParameter("username");
        String password = req.getParameter("password");

        for (User user : Objects.requireNonNull(UserDao.getAllUsers())) {
            if (user.getUsername().equals(username) && user.getPassword().equals(password)) {
                resp.sendRedirect("/tasks");
                session.setAttribute("username", username);
                session.setMaxInactiveInterval(60 * 5);
                return;

            }
        }

        resp.setContentType("text/html");
        PrintWriter writer = resp.getWriter();
        writer.println("<h1>User not found. Register first</h1>");


    }
}
