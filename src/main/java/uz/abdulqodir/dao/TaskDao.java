package uz.abdulqodir.dao;

import uz.abdulqodir.models.Task;
import uz.abdulqodir.models.User;
import uz.abdulqodir.utils.DbConnect;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

public class TaskDao {

    public static List<Task> getUserTasks(String username) throws SQLException {

        ArrayList<Task> tasks = new ArrayList<>();
        PreparedStatement preparedStatement = DbConnect.getConnection().prepareStatement("SELECT * FROM tasks t join users u on t.user_id=u.id where username='" + username + "'");
        ResultSet resultSet = preparedStatement.executeQuery();
        while (resultSet.next()) {
            int id = resultSet.getInt(1);
            String title = resultSet.getString(2);
            String description = resultSet.getString(3);
            boolean status = resultSet.getBoolean(4);
            Timestamp deadline = resultSet.getTimestamp(5);
            Timestamp createdAt = resultSet.getTimestamp(6);
            Timestamp updatedAt = resultSet.getTimestamp(7);
            int userId = resultSet.getInt(8);

            tasks.add(new Task(id, title, description,
                    status, deadline.toLocalDateTime(),
                    createdAt.toLocalDateTime(),
                    updatedAt.toLocalDateTime(), userId
            ));
        }
        return tasks;
    }

    public static boolean addNewTask(String title, String description, String deadline, String username) {
        Connection connection = DbConnect.getConnection();
        Integer user_id = null;
        for (User user : Objects.requireNonNull(UserDao.getAllUsers())) {
            if (user.getUsername().equals(username)) {
                user_id = user.getId();
            }
        }
        String addNewTask = "insert into tasks (title, description, deadline, user_id) VALUES ('" + title + "', '" + description + "', '" + deadline + "', " + user_id + ")";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addNewTask);
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static Task getTaskById(String id) {
        Connection connection = DbConnect.getConnection();
        String getTaskById = "select * from tasks where id =" + id;
        Task task = new Task();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(getTaskById);
            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                task.setId(resultSet.getInt(1));
                task.setTitle(resultSet.getString(2));
                task.setDescription(resultSet.getString(3));
                task.setStatus(resultSet.getBoolean(4));
                Timestamp deadline = resultSet.getTimestamp(5);
                if (deadline != null) {
                    task.setDeadline(deadline.toLocalDateTime());
                }
                Timestamp updatedAt = resultSet.getTimestamp(7);
                if (updatedAt != null) {
                    task.setUpdatedAt(updatedAt.toLocalDateTime());
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return task;

    }

    public static boolean editTaskById(Task task) {
        Connection connection = DbConnect.getConnection();
        String editSql = "update tasks set title='" + task.getTitle() + "', description='" + task.getDescription() + "', deadline='" + task.getDeadline() + "' where id=" + task.getId();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(editSql);
            preparedStatement.executeQuery();
            return true;
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }

    public static boolean deleteTaskById(int id) {
        Connection connection = DbConnect.getConnection();
        String deleteSql = "delete from tasks where id = " + id;
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(deleteSql);
            preparedStatement.executeQuery();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;
    }
}
