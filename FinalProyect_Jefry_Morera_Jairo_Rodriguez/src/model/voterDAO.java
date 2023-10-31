
package model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class voterDAO {
    
    public voterDAO(){
        
    }

    // Method to create a new voter record in the database
    public void createVoter(voter voter) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO voters (id_number, name, age, email, phone_number) VALUES (?, ?, ?, ?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, voter.getIdNumber());
            ps.setString(2, voter.getName());
            ps.setInt(3, voter.getAge());
            ps.setString(4, voter.getEmail());
            ps.setInt(5, voter.getPhoneNumber());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Votante insertado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar el votante, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

// Method to retrieve a list of all voters from the database
    public List<voter> readVoters() {
        DBConnectionJava db = new DBConnectionJava();
        List<voter> voters = new ArrayList<>();
        String sql = "SELECT * FROM voters";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int idNumber = resultSet.getInt("id_number");
                String name = resultSet.getString("name");
                int age = resultSet.getInt("age");
                String email = resultSet.getString("email");
                int phoneNumber = resultSet.getInt("phone_number");
                voters.add(new voter(id, name, idNumber, age, email, phoneNumber));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return voters;
    }

// Method to update an existing voter record in the database
    public void updateVoter(voter voter) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "UPDATE voters SET id_number=?, name=?, email=?, telephone =? WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, voter.getIdNumber());
            ps.setString(2, voter.getName());
            ps.setInt(3, voter.getAge());
            ps.setString(4, voter.getEmail());
            ps.setInt(5, voter.getPhoneNumber());
            ps.setInt(6, voter.getId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el votante, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

// Method to delete a voter record from the database by ID
    public void deleteVoter(int id) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM voters WHERE id=?";

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Votante eliminado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el votante, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

}
