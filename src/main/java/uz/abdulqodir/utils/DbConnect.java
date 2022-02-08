package uz.abdulqodir.utils;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import static uz.abdulqodir.utils.Constants.*;

public class DbConnect {
    public static Connection getConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            return DriverManager.getConnection(url, username, password);
        } catch (ClassNotFoundException | SQLException e) {
            e.printStackTrace();
        }
        return null;
    }
}
