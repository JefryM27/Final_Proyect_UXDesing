package model;

import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JOptionPane;

public class resultDAO {

    // Method to create a new result record in the database
    public void createResult(result result) {
        DBConnectionJava db = new DBConnectionJava();
        String consultaSQL = "INSERT INTO results (id_voter, id_candidate) VALUES (?, ?)";
        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, result.getVoterId());
            ps.setInt(2, result.getCandidateId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Resultado insertado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo insertar el resultado, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    // Method to retrieve a list of all results from the database
    public List<result> readResults() {
        DBConnectionJava db = new DBConnectionJava();
        List<result> results = new ArrayList<>();
        String sql = "SELECT * FROM results";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(sql);
            ResultSet resultSet = ps.executeQuery();
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                int voterId = resultSet.getInt("id_voter");
                int candidateId = resultSet.getInt("id_candidate");
                results.add(new result(id, voterId, candidateId));
            }
        } catch (SQLException e) {
            System.err.println("Error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
        return results;
    }

    // Method to update an existing result record in the database
    public void updateResult(result result) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "UPDATE results SET id_voter, id_candidate WHERE id=?";

        try {
            PreparedStatement ps = db.getConnection().prepareStatement(consultaSQL);
            ps.setInt(1, result.getVoterId());
            ps.setInt(2, result.getCandidateId());
            ps.execute();
            JOptionPane.showMessageDialog(null, "Modificación Exitosa");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo modificar el votante, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }

    // Method to delete a result record from the database by ID
    public void deleteVoter(int id) {
        DBConnectionJava db = new DBConnectionJava();

        String consultaSQL = "DELETE FROM results WHERE id=?";

        try {
            PreparedStatement preparedStatement = db.getConnection().prepareStatement(consultaSQL);
            preparedStatement.setInt(1, id);
            preparedStatement.execute();
            JOptionPane.showMessageDialog(null, "Resulto eliminado correctamente");
        } catch (SQLException e) {
            JOptionPane.showMessageDialog(null, "No se pudo eliminar el resultado, error: " + e.getMessage());
        } finally {
            db.disconnect();
        }
    }
}
