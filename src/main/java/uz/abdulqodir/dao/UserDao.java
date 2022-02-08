package uz.abdulqodir.dao;

import uz.abdulqodir.models.User;
import uz.abdulqodir.utils.DbConnect;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class UserDao {
    public static List<User> getAllUsers() {

        List<User> userList = new ArrayList<>();
        Connection connection = DbConnect.getConnection();
        try {
            PreparedStatement preparedStatement = connection.prepareStatement("SELECT * FROM users");

            ResultSet resultSet = preparedStatement.executeQuery();

            while (resultSet.next()) {
                int id = resultSet.getInt(1);
                String firstName = resultSet.getString(2);
                String lastName = resultSet.getString(3);
                String username = resultSet.getString(4);
                String password = resultSet.getString(5);
                userList.add(new User(id, firstName, lastName, username, password));
            }
            return userList;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return null;
    }

    public static boolean addUser(String firstName, String lastName, String username, String password) {
        Connection connection = DbConnect.getConnection();
        String addNewUser = "insert into users (first_name, last_name, username, password) " +
                "VALUES ('" + firstName + "', '" + lastName + "', '" + username + "','" + password + "');";
        try {
            PreparedStatement preparedStatement = connection.prepareStatement(addNewUser);
            preparedStatement.executeQuery();
            return true;

        } catch (SQLException e) {
            e.printStackTrace();
        }
        return false;

    }
}
