
package M;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;


public class userDAO {
    
    // Method to create a new result record in the database
    public void createUser(user user) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO users (name, password) VALUES (?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setString(1, user.getName());
            ps.setString(2, user.getPassword());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Usuario insertado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar el votante, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }
    
    // Method to retrieve a list of all users from the database
    public List<user> readUser() {
        DBConnectionJava db = new DBConnectionJava();
        List<user> users = new ArrayList<>();
        String sql = "SELECT * FROM users";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                String password = resultSet.getString("password");
                users.add(new user(id, name, password));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return users;
    }
    
    // Method to update an existing user record in the database
    public void updateUser(user user) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "UPDATE user SET name, password WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
        ps.setString(1, user.getName());
        ps.setString(2,user.getPassword());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el usuario, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }
    
    // Method to delete a result record from the database by ID
    public void deleteUser(int id) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM users WHERE id=?";

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Resulto eliminado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el usuario, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }
}
