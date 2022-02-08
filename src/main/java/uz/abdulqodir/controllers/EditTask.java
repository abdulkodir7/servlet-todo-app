package uz.abdulqodir.controllers;

import uz.abdulqodir.dao.TaskDao;
import uz.abdulqodir.models.Task;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/editTask")
public class EditTask extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        Task selectedTask = TaskDao.getTaskById(id);
        RequestDispatcher requestDispatcher = req.getRequestDispatcher("/jsp/task-form.jsp");
        req.setAttribute("selectedTask", selectedTask);
        requestDispatcher.forward(req, resp);
    }
}
