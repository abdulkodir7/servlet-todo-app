package uz.abdulqodir.controllers;

import uz.abdulqodir.dao.TaskDao;
import uz.abdulqodir.dao.UserDao;
import uz.abdulqodir.models.Task;
import uz.abdulqodir.models.User;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.sql.SQLException;
import java.sql.Timestamp;
import java.time.LocalDateTime;
import java.util.List;
import java.util.Objects;

@WebServlet("/tasks")
public class TaskController extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        for (User user : Objects.requireNonNull(UserDao.getAllUsers())) {
            if (user.getUsername().equals(username)) {
                List<Task> allTasks = null;
                try {
                    allTasks = TaskDao.getUserTasks(username);
                } catch (SQLException e) {
                    e.printStackTrace();
                }
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/view-tasks.jsp");
                req.setAttribute("taskList", allTasks);
                requestDispatcher.forward(req, resp);
                return;
            }
        }
        resp.sendRedirect("/login");

    }

    @Override
    protected void doPost(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        HttpSession session = req.getSession();
        String username = (String) session.getAttribute("username");

        Task task = new Task();
        String strId = req.getParameter("id");
        String title = req.getParameter("title");
        task.setTitle(title);
        String description = req.getParameter("description");
        task.setDescription(description);
        String deadline = req.getParameter("deadline");
        if (deadline != null) {
            task.setDeadline(LocalDateTime.parse(deadline));
        }

        if (strId != null && strId.length() > 0) {
            int id = Integer.parseInt(strId);
            if (id > 0) {
                task.setId(id);
                TaskDao.editTaskById(task);
                resp.sendRedirect("/tasks");
            }

        } else {
            TaskDao.addNewTask(title, description, deadline, username);
            resp.sendRedirect("/tasks");
        }
    }
}
