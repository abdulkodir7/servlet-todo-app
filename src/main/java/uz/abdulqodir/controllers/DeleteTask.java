package uz.abdulqodir.controllers;

import uz.abdulqodir.dao.TaskDao;

import javax.servlet.RequestDispatcher;
import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

@WebServlet(urlPatterns = "/deleteTask")
public class DeleteTask extends HttpServlet {
    @Override
    protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
        String id = req.getParameter("id");
        if (id != null) {
            int i = Integer.parseInt(id);
            if (TaskDao.deleteTaskById(i)) {
                RequestDispatcher requestDispatcher = req.getRequestDispatcher("/tasks");
                requestDispatcher.include(req, resp);
            }
        }

    }


}
