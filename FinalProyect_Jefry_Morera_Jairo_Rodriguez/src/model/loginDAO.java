/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class loginDAO {

    // Method to authenticate a user's login
    public String loginUser(String username, String password) {
        String role = "";
        String query = "SELECT r.name FROM users u "
                + "INNER JOIN roles r ON u.role_id = r.id "
                + "WHERE u.name = ? AND u.password = ?";

        // Use your database connection class to establish the connection 
        DBConnectionJava dbConnection = new DBConnectionJava();
        try (Connection connection = dbConnection.getConnection(); PreparedStatement preparedStatement = connection.prepareStatement(query)) {
            preparedStatement.setString(1, username);
            preparedStatement.setString(2, password);

            ResultSet resultSet = preparedStatement.executeQuery();
            if (resultSet.next()) {
                role = resultSet.getString("name");
            }
        } catch (SQLException e) {
            e.printStackTrace();
        } finally {
            dbConnection.disconnect();
        }

        return role;
    }
}
